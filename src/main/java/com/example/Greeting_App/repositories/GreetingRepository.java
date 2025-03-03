package com.example.Greeting_App.repositories;

import com.example.Greeting_App.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface GreetingRepository extends JpaRepository<MessageEntity, Long> {


}