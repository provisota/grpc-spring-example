package com.example.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcHelloClient {

    @GrpcClient("hello")
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String sendMessage(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        System.out.printf("*** gRPC Client sent the request to the server: '%s' ***%n", request.getName());

        HelloResponse response = helloServiceBlockingStub.sayHello(request);
        System.out.printf("*** gRPC Client received the response from the server: '%s' ***%n", response.getMessage());

        return response.getMessage();
    }

}
