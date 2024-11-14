package com.example.demo.service;

import com.example.demo.entity.Chatroom;
import com.example.demo.repo.ChatroomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChatroomService {
    @Autowired
    private ChatroomRepository repo;
    public Iterable<Chatroom> listAll() {
        return repo.findAll();
    }
    public void save(Chatroom chatroom) {
        repo.save(chatroom);
    }
    public Chatroom get(Integer id) {
        return repo.findById(id).get();
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Chatroom> getAllChatrooms() {
        Iterable<Chatroom> iterable = listAll();
        List<Chatroom> chatrooms = new ArrayList<>();
        iterable.forEach(chatrooms::add);
        return chatrooms;
    }
}
