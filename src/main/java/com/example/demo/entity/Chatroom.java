package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chatroom {
    @Id // primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) // match with auto increment
    private Integer id;

    private String name;

    public String getId() { return name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
