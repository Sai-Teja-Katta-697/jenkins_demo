package com.docker.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final EmailSenderService emailService;

    public DemoController(EmailSenderService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String demoMethod() {

        throw new RuntimeException("Intentional failure to stop the build");
        return "This is demo for docker";
    }

    @GetMapping("/confirmation")
    public String demoSecondMethod() {
        return "This is demo for CI CD PipeLines";
    }

    @PostMapping("/sendPlainTextEmail")
    public ResponseEntity<String> sendPlainTextEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendPlainTextEmail(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }
}
