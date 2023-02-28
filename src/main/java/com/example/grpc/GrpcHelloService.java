package com.example.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcHelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        final String requestName = request.getName();
        System.out.printf("*** gRPC Server received the request from the client: '%s' ***%n", requestName);

        String responseMessage = String.format("Hello, %s!", requestName);
        HelloResponse response = HelloResponse.newBuilder().setMessage(responseMessage).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.printf("*** gRPC Server sent the response to the client: '%s' ***%n", response.getMessage());
    }
}