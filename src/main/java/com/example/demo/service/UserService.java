package com.example.demo.service;
import java.util.List;
import java.util.Objects;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    // An annotation enables dependency injection for Java classes
    @Autowired
    private UserRepository repo;
    public Iterable<User> listAll() {
        return repo.findAll();
    }
    public void save(User user) {
        repo.save(user);
    }
    public User get(Integer id) {
        return repo.findById(id).get();
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    public Boolean login(UserLogin userLogin) {
        String email = userLogin.getEmail();
        String password = userLogin.getPassword();
        User user = repo.findByEmail(email);
        if (user != null && Objects.equals(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }
}