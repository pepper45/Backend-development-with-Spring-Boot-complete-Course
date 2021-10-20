package com.example.backend.controller.basic;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping(
            path = "/api1",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            params = {"k1", "k2"},
            headers = {HttpHeaders.DATE})
    public String api1(
            @RequestParam("k1") String k1,
            @RequestParam(value = "k2", required = false) String k2,
            @RequestParam(value = "k3", required = true) String k3) {
        return "API 1" + (k1 == null ? "A" : k1) + (k2 == null ? "B" : k2) + k3;
    }

    @GetMapping(
            path = "/api2",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    public String api2() {
        return "API 2";
    }
}
