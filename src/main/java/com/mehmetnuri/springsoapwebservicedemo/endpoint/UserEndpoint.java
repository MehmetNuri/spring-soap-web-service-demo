package com.mehmetnuri.springsoapwebservicedemo.endpoint;

import com.mehmetnuri.spring_boot_soap_web_service_demo.GetUserRequest;
import com.mehmetnuri.spring_boot_soap_web_service_demo.GetUserResponse;
import com.mehmetnuri.springsoapwebservicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private final UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }


    @PayloadRoot(namespace = "http://mehmetnuri.com/spring-boot-soap-web-service-demo",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}