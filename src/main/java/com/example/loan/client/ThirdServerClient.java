package com.example.loan.client;

import lombok.SneakyThrows;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ThirdServerClient {
    private final RestTemplate restTemplate = new RestTemplate();

    private String get(String path) {
        return restTemplate.exchange(RequestEntity.get(makeUri(path))
                .header("Accept", "application/json")
                .build(), String.class).getBody();
    }

    @SneakyThrows
    private URI makeUri(String path) {
        return URI.create(String.format("http://127.0.0.1:%s%s", 8019, path));
    }

}
