package com.docker.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class EmailRequest {

    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String text;
    private String attachmentPath;
    private List<String> inlineImagesPath;
    private List<List<String>> tableData;
    
    // Getters and setters
}