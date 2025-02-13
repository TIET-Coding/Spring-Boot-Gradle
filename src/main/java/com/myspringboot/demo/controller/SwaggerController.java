package com.myspringboot.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello API", description = "API for greeting users")
public class SwaggerController {

    @GetMapping("/hello")
    @Operation(summary = "Say Hello", description = "Returns a simple greeting message")
    public String sayHello() {
        return "Hello, ]!";
    }
}
