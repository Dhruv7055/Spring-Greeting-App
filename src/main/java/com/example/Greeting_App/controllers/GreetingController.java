package com.example.Greeting_App.controllers;

import com.example.Greeting_App.dto.MessageDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greetings")
public class GreetingController {

    @GetMapping("/get")
    public String getGreetings(){
        return "{\"message\": \"Hello from GET Request!\"}";
    }

    @PostMapping("/post")
    public String postGreetings(@RequestBody MessageDTO message){
        return "{\""+message.getMessage()+": \"Hello from POST Request!\"}";
    }

    @PutMapping("/put/{message}")
    public String putGreetings(@PathVariable String message){
        return "{\""+message+": \"Hello from PUT Request!\"}";
    }



}