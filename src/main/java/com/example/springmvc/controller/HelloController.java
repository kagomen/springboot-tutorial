package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// クラス全体がHTTPリクエストを受け取ってレスポンスを返すものになる
@Controller
public class HelloController {

  // GET /hello に応答
  @GetMapping("/hello")
  public String sayHello(Model model) {
    model.addAttribute("name", "World");
    return "hello"; // resources/templates/hello.htmlに繋ぐ
  }
}
