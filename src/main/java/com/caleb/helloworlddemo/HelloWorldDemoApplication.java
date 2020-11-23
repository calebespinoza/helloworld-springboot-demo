package com.caleb.helloworlddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
//@RequestMapping(value="hello")
public class HelloWorldDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldDemoApplication.class, args);
    }

    // First Demo
    @GetMapping
    public String sayHello (@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // Second Demo
    //@RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
    //public String hello ( @PathVariable("firstName") String firstName,
    //                      @PathVariable("lastName") String lastName) {
    //    return String.format("{\"message\" : \"Hello %s %s\"}", firstName, lastName);
    //}
}
