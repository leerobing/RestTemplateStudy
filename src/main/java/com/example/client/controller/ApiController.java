package com.example.client.controller;

import com.example.client.entity.User;
import com.example.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService restTemplateService;

    @PostMapping("/hello")
    public User getHello(@RequestBody User user) {
        User hello = restTemplateService.hello(user);
        return hello;
    }
}
