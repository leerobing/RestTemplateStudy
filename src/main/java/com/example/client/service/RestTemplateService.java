package com.example.client.service;

import com.example.client.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {

    public User hello(User user) {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        log.info("uri = {}",uri);

        RestTemplate restTemplate = new RestTemplate();

//        String result = restTemplate.getForObject(uri, String.class);

        RequestEntity<User> requestEntity = RequestEntity
                .post(uri)
                .header("x-authorization","asd")
                .header("custom-header" , "qwer")
                .body(user);

//        ResponseEntity<User> result = restTemplate.postForEntity(uri,user, User.class);

        ResponseEntity<User> result = restTemplate.exchange(requestEntity, User.class);

        log.info("result_body = {}",result.getBody());
        log.info("result_code = {}", result.getStatusCode());

        return result.getBody();

    }
}
