package com.example.backend.controller.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static String serverId;
    @Autowired
    ApplicationArguments args;

    @RequestMapping("/world")
    String home() {
        return "Hello World";
    }

    @RequestMapping("/server")
    public String server(HttpServletRequest request) {
        return "Hello from server : " + args.getSourceArgs()[0];
    }
}
