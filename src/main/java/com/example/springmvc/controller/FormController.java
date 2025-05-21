package com.example.springmvc.controller;

import com.example.springmvc.model.User;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
  @GetMapping("form")
  public String showForm(Model model) {
    model.addAttribute("user", new User());
    return "form";
  }

  @PostMapping("form")
  public String submitForm(@Valid @ModelAttribute User user, BindingResult result) {
    if (result.hasErrors()) {
      return "form";
    }
    return "result";
  }

  @ModelAttribute("genderOptions")
  public List<String> genderOptions() {
    return List.of("male", "female", "other");
  }

  @ModelAttribute("interestOptions")
  public List<String> interestOptions() {
    return List.of("programming", "music", "soccer", "tennis");
  }
}
