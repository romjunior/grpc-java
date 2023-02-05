package com.exemplo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DummyClientMain {
    public static void main(String[] args) {
        System.out.println("Hello Client");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .build();

        System.out.println("Creating stub");
        /*DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc
                .newBlockingStub(channel);

        //DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc
       //         .newFutureStub(channel);*/


        //do something

        System.out.println("Shutting down channel");
        channel.shutdown();


    }
}
