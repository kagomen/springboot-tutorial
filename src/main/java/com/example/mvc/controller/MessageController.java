package com.example.mvc.controller;

import com.example.mvc.model.MessageModel;
import com.example.mvc.view.MessageView;

public class MessageController {
  private final MessageModel model;
  private final MessageView view;

  public MessageController(MessageModel model, MessageView view) {
    this.model = model;
    this.view = view;
  }

  public void showMessage() {
    String message = model.getMessage(); // データはModelに任せる
    view.render(message); // 表示はViewに任せる
  }
}
