package com.exemplo.server;

import com.exemplo.sum.AverageRequest;
import com.exemplo.sum.AverageResponse;
import com.exemplo.sum.MaximumRequest;
import com.exemplo.sum.MaximumResponse;
import com.exemplo.sum.PrimeNumberRequest;
import com.exemplo.sum.PrimeNumberResponse;
import com.exemplo.sum.SquareRootRequest;
import com.exemplo.sum.SquareRootResponse;
import com.exemplo.sum.SumRequest;
import com.exemplo.sum.SumResponse;
import com.exemplo.sum.SumServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        final var num1 = request.getNum1();
        final var num2 = request.getNum2();

        final var result = num1 + num2;

        final var response = SumResponse
                .newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void primeNumberDecomposition(PrimeNumberRequest request, StreamObserver<PrimeNumberResponse> responseObserver) {
        var num = request.getNumber();

        var divisor = 2;

        while (num >  1) {
            if(num % divisor == 0) {
                num = num / divisor;
                responseObserver.onNext(PrimeNumberResponse.newBuilder()
                        .setPrimeFactor(divisor)
                        .build());
            } else {
                divisor += 1;
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AverageRequest> average(StreamObserver<AverageResponse> responseObserver) {
        return new StreamObserver<>() {
            int sum = 0;
            int count = 0;

            @Override
            public void onNext(AverageRequest value) {
                sum += value.getNumber();
                count++;
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(AverageResponse.newBuilder()
                                .setNumber(sum/count)
                        .build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<MaximumRequest> maximumNumber(StreamObserver<MaximumResponse> responseObserver) {
        return new StreamObserver<>() {

            int max = 0;

            @Override
            public void onNext(MaximumRequest value) {
                if(value.getNumber() > max) {
                    max = value.getNumber();
                    responseObserver.onNext(MaximumResponse.newBuilder()
                                    .setNumber(max)
                            .build());
                }
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(MaximumResponse.newBuilder()
                        .setNumber(max)
                        .build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        if(request.getNumber() > 0) {
            final var result = Math.sqrt(request.getNumber());
            responseObserver.onNext(SquareRootResponse
                    .newBuilder()
                    .setNumber(result)
                    .build());
        } else {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("Number is negative!")
                            .augmentDescription("Number sent " + request.getNumber())
                    .asRuntimeException()
            );
        }

        responseObserver.onCompleted();
    }
}
