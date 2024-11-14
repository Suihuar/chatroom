package com.example.demo.repo;

import com.example.demo.entity.Chatroom;
import org.springframework.data.repository.CrudRepository;
public interface ChatroomRepository extends CrudRepository<Chatroom, Integer> {

}