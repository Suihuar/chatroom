package com.example.demo.controller;

import com.example.demo.entity.Chatroom;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.service.ChatroomService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MvcController {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatroomService chatroomService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addNewUser(@Valid @ModelAttribute User user) {
        userService.save(user);
        return "Saved";
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("Going home..."); // appear in the console
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        UserLogin userLogin = new UserLogin();
        model.addAttribute("userLogin", userLogin);
        return "login_form";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserLogin userLogin, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userLogin", userLogin);
            return "login_form";
        } else {
            if (userService.login(userLogin)) {
                System.out.println("Login success");
                model.addAttribute("userLogin", userLogin);
                User currentUser = userService.getUserByEmail(userLogin.getEmail());
                System.out.println("login: " + currentUser.getName());
                session.setAttribute("currentUser", currentUser);
                return "redirect:/lobby";
            } else {
                System.out.println("Login failed");
                model.addAttribute("userLogin", userLogin);
                model.addAttribute("loginError", "Invalid email or password");

                return "login_form";
            }
        }
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        String[] professionList = new String[3];
        professionList[0] = "Developer";
        professionList[1] = "Designer";
        professionList[2] = "Tester";
        model.addAttribute("user", user);
        model.addAttribute("professionList", professionList);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute User user, BindingResult
            bindingResult, Model model) {
//        System.out.println(user); // the user information is displayed in the console
        if (bindingResult.hasErrors()) {
            String[] professionList = new String[3];
            professionList[0] = "Developer";
            professionList[1] = "Designer";
            professionList[2] = "Tester";
            model.addAttribute("user", user);
            model.addAttribute("professionList", professionList);
            return "register_form";
        } else {
            model.addAttribute("user", user);
            userService.save(user);
            return "login";
        }
    }

    @GetMapping("/account")
    public String showAccountForm(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        String[] professionList = new String[3];
        professionList[0] = "Developer";
        professionList[1] = "Designer";
        professionList[2] = "Tester";
        model.addAttribute("professionList", professionList);
        return "account";
    }

    @PostMapping("update")
    public String updateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            String[] professionList = new String[3];
            professionList[0] = "Developer";
            professionList[1] = "Designer";
            professionList[2] = "Tester";
            model.addAttribute("user", user);
            model.addAttribute("professionList", professionList);
            return "account";
        } else {
            User currentUser = (User) session.getAttribute("currentUser");
            System.out.println(currentUser.getName());
            currentUser.setName(user.getName());
            currentUser.setEmail(user.getEmail());
            currentUser.setPassword(user.getPassword());
            currentUser.setGender(user.getGender());
            currentUser.setProfession(user.getProfession());
            currentUser.setNote(user.getNote());
            currentUser.setBirthday(user.getBirthday());
            currentUser.setMarried(user.isMarried());
            userService.save(currentUser);
            session.setAttribute("currentUser", currentUser);
            model.addAttribute("user", currentUser);
            model.addAttribute("updateSuccess", "Account Information Update Success");
            return "redirect:/account";
        }
    }

    @GetMapping("/lobby")
    public String showLobby(Model model, HttpSession session) {
        List<Chatroom> chatrooms = chatroomService.getAllChatrooms();
        model.addAttribute("chatrooms", chatrooms);
        return "lobby";
    }
}