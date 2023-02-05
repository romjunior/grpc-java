package com.exemplo.client;

import com.example.greet.GreetRequest;
import com.example.greet.GreetResponse;
import com.example.greet.GreetServiceGrpc;
import com.example.greet.Greeting;
import io.grpc.ChannelCredentials;
import io.grpc.Deadline;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.TlsChannelCredentials;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClientMain {


    public void run() throws IOException {
        System.out.println("Hello Greeting Client");
        //plaintext channel
        /*ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();*/

        ChannelCredentials creds = TlsChannelCredentials.newBuilder()
                .trustManager(new File("ssl/ca.crt"))
                .build();

        ManagedChannel channel = Grpc.newChannelBuilder("localhost:50051",  creds)
                .build();

        System.out.println("Creating blocking stub");
        final var syncClient = GreetServiceGrpc
                .newBlockingStub(channel);

        System.out.println("Creating non-blocking stub");
        final var asyncClient = GreetServiceGrpc.newStub(channel);

        final var greeting = Greeting
                .newBuilder()
                .setFirstName("Rom")
                .setLastName("Junior")
                .build();

        final var request = GreetRequest
                .newBuilder()
                .setGreeting(greeting)
                .build();

        doUnaryCall(syncClient, request);
        doServerStreamingCall(syncClient, request);
        doClientStreamingCall(asyncClient, request);
        doBidirectionalStreamingcall(asyncClient, request);
        doUnaryCallWithDeadline(syncClient, request);
        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private void doUnaryCall(GreetServiceGrpc.GreetServiceBlockingStub syncClient, GreetRequest request) {
        final var result = syncClient.greet(request);
        System.out.println(result.getResult());
    }

    private void doUnaryCallWithDeadline(GreetServiceGrpc.GreetServiceBlockingStub syncClient, GreetRequest request) {
        try {
            final var result = syncClient.withDeadline(Deadline.after(500, TimeUnit.MILLISECONDS)).greetWithDeadline(request);
            System.out.println(result.getResult());
        }catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode());
            System.out.println("Deadline exceeded, we dont want the answer");
        }
    }

    private void doServerStreamingCall(GreetServiceGrpc.GreetServiceBlockingStub syncClient, GreetRequest request) {
        syncClient.greetManyTimes(request)
                .forEachRemaining(response -> System.out.println(response.getResult()));
    }

    private void doClientStreamingCall(GreetServiceGrpc.GreetServiceStub asyncClient, GreetRequest request) {

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<>() {
            @Override
            public void onNext(GreetResponse value) {
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Server has completed");
                latch.countDown();
            }
        });

        for (int i = 1; i <= 10; i++ ) {
            System.out.println("Sending Message " + i);
            requestObserver.onNext(GreetRequest.newBuilder()
                    .setGreeting(Greeting.newBuilder()
                            .setFirstName("Teste " + i)
                            .setLastName("Last " + i)
                            .build())
                    .build());
        }

        requestObserver.onCompleted();

        try {
            latch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doBidirectionalStreamingcall(GreetServiceGrpc.GreetServiceStub asyncClient, GreetRequest request) {

        CountDownLatch latch = new CountDownLatch(1);

        final var requestObserver = asyncClient.greetEveryone(new StreamObserver<GreetResponse>() {
            @Override
            public void onNext(GreetResponse value) {
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Bidi completed");
                latch.countDown();
            }
        });

        requestObserver.onNext(GreetRequest
                .newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("John")
                        .setLastName("Silva")
                        .build())
                .build());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        requestObserver.onNext(GreetRequest
                .newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Marina")
                        .setLastName("Silva")
                        .build())
                .build());

        requestObserver.onCompleted();

        try {
            latch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        GreetingClientMain test = new GreetingClientMain();
        test.run();
    }
}
