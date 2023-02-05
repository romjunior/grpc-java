package com.exemplo.server;

import com.example.greet.GreetRequest;
import com.example.greet.GreetResponse;
import com.example.greet.GreetServiceGrpc;
import com.example.greet.Greeting;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        Greeting greeting = request.getGreeting();
        final var firstName = greeting.getFirstName();
        final var lastName = greeting.getLastName();

        final var result = new StringBuilder().append("Hello ")
                .append(firstName)
                .append(lastName);

        final var response = GreetResponse.newBuilder()
                .setResult(result.toString())
                .build();

        //send a response
        responseObserver.onNext(response);

        //complete the RPC call
        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetRequest request, StreamObserver<GreetResponse> responseObserver)  {
        Greeting greeting = request.getGreeting();
        final var firstName = greeting.getFirstName();
        final var lastName = greeting.getLastName();

        try {
            for (int i = 0; i < 10; i++) {

                final var result = new StringBuilder().append("Hello ")
                        .append(firstName)
                        .append(lastName)
                        .append(", response number: ")
                        .append(i);


                final var response = GreetResponse.newBuilder()
                        .setResult(result.toString())
                        .build();

                //send a response
                responseObserver.onNext(response);
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //complete the RPC call
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<GreetRequest> longGreet(StreamObserver<GreetResponse> responseObserver) {
        return new StreamObserver<>() {

            StringBuilder result = new StringBuilder();

            @Override
            public void onNext(GreetRequest value) {
                result.append("Hello ")
                        .append(value.getGreeting().getFirstName())
                        .append("!");
            }

            @Override
            public void onError(Throwable t) {
                //client send an error
            }

            @Override
            public void onCompleted() {
                //client is done
                responseObserver.onNext(GreetResponse.newBuilder()
                        .setResult(result.toString())
                        .build()
                );
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<GreetRequest> greetEveryone(StreamObserver<GreetResponse> responseObserver) {
        return new StreamObserver<>() {

            @Override
            public void onNext(GreetRequest value) {
                String response = "Hello " + value.getGreeting().getFirstName() + value.getGreeting().getLastName() +  " !";
                responseObserver.onNext(GreetResponse.newBuilder()
                                .setResult(response)
                        .build());
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void greetWithDeadline(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        Context current = Context.current();

        for(int i = 0; i < 6; i++) {
            try {
                if(!current.isCancelled()) {
                    System.out.println("Sleepling..");
                    Thread.sleep(100);
                } else {
                    System.out.println("Canceled..");
                    return;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Greeting greeting = request.getGreeting();
        final var firstName = greeting.getFirstName();
        final var lastName = greeting.getLastName();

        final var result = new StringBuilder().append("Hello ")
                .append(firstName)
                .append(lastName);

        final var response = GreetResponse.newBuilder()
                .setResult(result.toString())
                .build();

        //send a response
        responseObserver.onNext(response);

        //complete the RPC call
        responseObserver.onCompleted();
    }
}
