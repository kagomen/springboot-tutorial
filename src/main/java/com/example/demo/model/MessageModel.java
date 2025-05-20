package com.example.demo.model;

public class MessageModel {
  private String message;

  public MessageModel(String message) {
    this.message = message;
  }

  // メッセージ内容を動的にしたりなどの変更はModelが担当する
  public String getMessage() {
    return this.message;
  }
}
