package com.jkmalra.Portfolioapi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> handleContact(@Valid @RequestBody ContactForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ")
            );
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }

        emailService.sendContactEmail(form);

        System.out.println("New Contact Submission:");
        System.out.println("Name: " + form.getName());
        System.out.println("Email: " + form.getEmail());
        System.out.println("Message: " + form.getMessage());

        return new ResponseEntity<>("message received successfully!", HttpStatus.OK);
    }
}
