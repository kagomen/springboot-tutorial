package com.example.three_layer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ハンドラーメソッドの戻り値がレスポンスボディに書き出されるようになる
@RequestMapping("/tasks3")
public class TaskItemController {
  @GetMapping
  public TaskItemDTO index() {
    return new TaskItemDTO();
  }
}
