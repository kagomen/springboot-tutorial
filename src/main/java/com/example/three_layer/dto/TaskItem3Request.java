package com.example.three_layer.dto;

import lombok.Data;

// クライアントから受け取るリクエストボディ用
// IDはクライアントから送られないので含めない
@Data
public class TaskItem3Request {
  private String title;
  private boolean done;
}
