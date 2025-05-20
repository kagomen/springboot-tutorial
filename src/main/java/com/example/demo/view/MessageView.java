package com.example.demo.view;

public class MessageView {
  // jsonやhtml、pdfを返すといった変更はViewの担当領域
  public void render(String message) {
    System.out.println(message);
  }
}
