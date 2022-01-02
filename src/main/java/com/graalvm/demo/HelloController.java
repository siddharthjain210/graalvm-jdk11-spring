package com.graalvm.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

  @GetMapping("/")
  public String index() {
    log.info("Inside / Function");
    return "Greetings from Spring Boot!";
  }

  @PostMapping("/hello")
  public ResponseEntity<HelloResponse> hello(
    @RequestBody HelloRequest helloRequest
  ) {
    log.info("inside Post Hello Request Function");
    return ResponseEntity.ok(new HelloResponse());
  }
}
