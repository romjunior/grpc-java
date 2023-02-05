package com.exemplo.server;

import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import io.grpc.TlsServerCredentials;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.File;
import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello Server!");

        //Plaintext Server
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .addService(new SumServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();



        /*ServerCredentials creds = TlsServerCredentials.create(new File("ssl/server.crt"), new File("ssl/server.pem"));
        Server server = Grpc.newServerBuilderForPort(50051, creds)
                .addService(new GreetServiceImpl())
                .addService(new SumServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
*/
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }
}