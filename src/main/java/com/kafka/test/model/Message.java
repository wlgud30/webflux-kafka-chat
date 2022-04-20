package com.kafka.test.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message implements Serializable {

    private String author;

    private String content;

    private String timestamp;

    private String enable;

    public Message(String author, String content) {
        this.author = author;
        this.content = content;
    }
}
