package com.example.springmvc.controller;

import com.example.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/user")
  public String showUser(Model model) {
    var user = new User("John", "john@example.com", 20);
    model.addAttribute("user", user);
    return "user";
  }
}
