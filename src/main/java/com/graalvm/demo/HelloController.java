package com.graalvm.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @PostMapping("/hello")
  public ResponseEntity<HelloResponse> hello(
    @RequestBody HelloRequest helloRequest
  ) {
    return ResponseEntity.ok(new HelloResponse());
  }
}
