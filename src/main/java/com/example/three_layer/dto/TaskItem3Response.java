package com.example.three_layer.dto;

import lombok.Data;

// クライアントに返すレスポンスボディ用
// IDも含めて返す
@Data
public class TaskItem3Response {
  private Integer id;
  private String title;
  private boolean done;
}
