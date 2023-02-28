package com.example.grpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

    public RestClientController(GrpcHelloClient grpcHelloClient) {
        this.grpcHelloClient = grpcHelloClient;
    }

    private final GrpcHelloClient grpcHelloClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return grpcHelloClient.sendMessage(name);
    }
}