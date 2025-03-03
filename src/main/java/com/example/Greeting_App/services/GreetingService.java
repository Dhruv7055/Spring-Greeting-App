package com.example.Greeting_App.services;

import com.example.Greeting_App.dto.MessageDTO;
import com.example.Greeting_App.entities.MessageEntity;
import com.example.Greeting_App.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    String message;
    GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
        message = "Hello World!";
    }


    public String getGreetings(){
        return this.message;
    }

    public MessageDTO saveMessage(MessageDTO message){

        MessageEntity me = new MessageEntity(message.getMessage());

        greetingRepository.save(me);

        MessageDTO dto = new MessageDTO(me.getMessage());

        dto.setId(me.getId());

        return dto;
    }

}