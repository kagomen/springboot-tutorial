package com.example.demo;

import com.example.demo.controller.MessageController;
import com.example.demo.model.MessageModel;
import com.example.demo.view.MessageView;

public class Main {
  public static void main(String[] args) {
    var model = new MessageModel("Hello World");
    var view = new MessageView();
    var controller = new MessageController(model, view);

    controller.showMessage();
  }
}
