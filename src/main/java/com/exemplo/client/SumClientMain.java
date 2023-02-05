package com.exemplo.client;

import com.exemplo.sum.AverageRequest;
import com.exemplo.sum.AverageResponse;
import com.exemplo.sum.MaximumRequest;
import com.exemplo.sum.MaximumResponse;
import com.exemplo.sum.PrimeNumberRequest;
import com.exemplo.sum.SquareRootRequest;
import com.exemplo.sum.SumRequest;
import com.exemplo.sum.SumServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.checkerframework.checker.units.qual.C;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SumClientMain {

    public void run() {

        System.out.println("Hello Sum Client");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");
        final var syncClient = SumServiceGrpc
                .newBlockingStub(channel);

        final var asyncClient = SumServiceGrpc
                .newStub(channel);

        doUnary(syncClient);
        doServerStreaming(syncClient);
        doClientStreaming(asyncClient);
        doBiDiStreaming(asyncClient);
        doErrorCall(syncClient);
        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private void doUnary(SumServiceGrpc.SumServiceBlockingStub syncClient) {
        final var request = SumRequest
                .newBuilder()
                .setNum1(10)
                .setNum2(25)
                .build();

        //RPC call
        final var result = syncClient.sum(request);

        System.out.println(result.getResult());
    }

    private void doServerStreaming(SumServiceGrpc.SumServiceBlockingStub syncClient) {
        final var primeRequest = PrimeNumberRequest
                .newBuilder()
                .setNumber(104717)
                .build();

        System.out.println("Calculating number prime");
        syncClient.primeNumberDecomposition(primeRequest)
                .forEachRemaining(primeNumberResponse -> System.out.println(primeNumberResponse.getPrimeFactor()));
    }

    private void doClientStreaming(SumServiceGrpc.SumServiceStub asyncClient) {
        System.out.println("Calculating average by client stream");
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AverageRequest> requestObserver = asyncClient.average(new StreamObserver<>() {
            @Override
            public void onNext(AverageResponse value) {
                System.out.println("Average is: " + value.getNumber());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Done rpc call Average");
                latch.countDown();

            }
        });

        for (int i = 1; i < 10; i++) {
            final var num = Double.valueOf(100 * Math.random()).intValue();
            System.out.println("Sending average number" + num);
            requestObserver.onNext(AverageRequest.newBuilder()
                    .setNumber(num)
                    .build());
        }

        System.out.println("Completed call");
        requestObserver.onCompleted();

        try {
            latch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doBiDiStreaming(SumServiceGrpc.SumServiceStub asyncClient) {
        System.out.println("Calculating MaximumNumber");

        CountDownLatch latch = new CountDownLatch(1);

        final var requestObserver = asyncClient.maximumNumber(new StreamObserver<MaximumResponse>() {
            @Override
            public void onNext(MaximumResponse value) {
                System.out.println("Maximum is: " + value.getNumber());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println(t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("BiDi has completed!");
                latch.countDown();
            }
        });

        List.of(1, 2, 5, 12, 30, 45, 20, 10, 20, 31, 5, 4, 3, 3).forEach(n -> {
            System.out.println("Sending: " + n);
            requestObserver.onNext(MaximumRequest
                    .newBuilder()
                            .setNumber(n)
                    .build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        requestObserver.onCompleted();

        try {
            latch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doErrorCall(SumServiceGrpc.SumServiceBlockingStub syncClient) {
        try {
            final var result = syncClient
                    .squareRoot(SquareRootRequest.newBuilder()
                            .setNumber(-12)
                            .build());
            System.out.println(result.getNumber());
        }catch (StatusRuntimeException e) {
            System.out.println(Status.INVALID_ARGUMENT.getCode().equals(e.getStatus().getCode()));
                System.err.println(e.getStatus());
                System.err.println("Erro de argumento inválido");
                System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SumClientMain main = new SumClientMain();
        main.run();
    }
}
