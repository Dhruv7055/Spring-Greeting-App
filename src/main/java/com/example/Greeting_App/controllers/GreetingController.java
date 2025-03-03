package com.example.Greeting_App.controllers;

import com.example.Greeting_App.dto.MessageDTO;
import com.example.Greeting_App.repositories.GreetingRepository;
import com.example.Greeting_App.services.GreetingService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("greetings")
public class GreetingController {
    GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * UC1-GreetingRestAPI
     * GET request - Returns a simple greeting message.
     * URL: http://localhost:8080/greetings/get
     */
    @GetMapping("/get")
    public String getGreetings(){
        return "{\"message\": \"Hello from GET Request!\"}";
    }

    /**
     * POST request - Accepts a message in the request body and returns a greeting.
     * URL: http://localhost:8080/greetings/post
     * Body: { "message": "Dhruv" }
     */
    @PostMapping("/post")
    public String postGreetings(@RequestBody MessageDTO message){
        return "{\""+message.getMessage()+": \"Hello from POST Request!\"}";
    }

    /**
     * PUT request - Updates a message via URL path variable.
     * URL: http://localhost:8080/greetings/put/{message}
     */
    @PutMapping("/put/{message}")
    public String putGreetings(@PathVariable String message){
        return "{\""+message+": \"Hello from PUT Request!\"}";
    }

    /**
     * DELETE request - Deletes a message via URL path variable.
     * URL: http://localhost:8080/greetings/delete/{message}
     */
    @DeleteMapping("/delete/{message}")
    public String greetingDelete(@PathVariable String message) {
        return "Hello Delete Request from " + message;
    }

    /**

     * PATCH request - Partially updates a message.
     * URL: http://localhost:8080/greetings/patch/{message}
     */
    @PatchMapping("/patch/{message}")
    public String greetingPatch(@PathVariable String message) {
        return "Hello Patch Request from " + message;
    }

    // UC2
    @GetMapping("/service")
    public String serviceGreetings(){
        return greetingService.getGreetings();
    }

    /**
     *   UC3-QueryParams
     * GET request - Accepts query parameters for firstName and lastName.
     * URL Examples:
     * - http://localhost:8080/greetings/query?firstName=Dhruv&lastName=Agarwal
     * - http://localhost:8080/greetings/query?firstName=Dhruv
     * - http://localhost:8080/greetings/query?lastName=Agarwal
     */
    @GetMapping("/query")
    public String query(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){
        if(firstName != null && lastName != null)
            return "Hello "+firstName+" "+lastName+" Welcome to Bridgelabz";
        else if(firstName != null)
            return "Hello "+firstName+" Welcome to Bridgelabz";
        else if(lastName != null)
            return "Hello "+lastName+" Welcome to Bridgelabz";
        else
            return "Hello, Welcome to Bridgelabz";
    }

    /**
     * UC4 - Saving Mwssage in DataBase
     * POST request - Saves a message using the service layer.
     * URL: http://localhost:8080/greetings/save
     * Body: { "message": "Hello Spring Boot" }
     */
    @PostMapping("/save")
    public MessageDTO save(@RequestBody MessageDTO message){
        return greetingService.saveMessage(message);
    }

    /**
     * UC5- Find Message by ID
     * GET request - Finds a message by its ID.
     * URL: http://localhost:8080/greetings/find/{id}
     */
    @GetMapping("/find/{id}")
    public MessageDTO findById(@PathVariable Long id){

        return greetingService.findById(id);

    }

    /**
     *   UC6-List All Messages
     * GET request - Retrieves all stored messages.
     * URL: http://localhost:8080/greetings/listAll
     */
    @GetMapping("/listAll")
    public List<MessageDTO> listAll(){
        return greetingService.listAll();
    }

    /**
     *   UC7-EditMessage
     * PUT request - Updates a message by ID.
     * URL: http://localhost:8080/greetings/edit/{id}
     * Body: { "message": "Updated message" }
     */
    @PostMapping("/edit/{id}")
    public MessageDTO editById(@RequestBody MessageDTO message, @PathVariable Long id){
        return greetingService.editById(message, id);
    }

    /**
     *   UC8-DeleteMessages
     * DELETE request - Deletes a message by ID.
     * URL: http://localhost:8080/greetings/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return greetingService.delete(id);
    }
}