package com.example.mvc;

import com.example.mvc.controller.MessageController;
import com.example.mvc.model.MessageModel;
import com.example.mvc.view.MessageView;

public class Main {
  public static void main(String[] args) {
    var model = new MessageModel("Hello World");
    var view = new MessageView();
    var controller = new MessageController(model, view);

    controller.showMessage();
  }
}
