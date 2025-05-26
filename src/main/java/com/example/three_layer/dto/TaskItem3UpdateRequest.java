package com.example.three_layer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskItem3UpdateRequest {

  @NotBlank(message = "必須項目です")
  @Size(max = 100, message = "100文字以内で入力してください")
  private String title;

  private boolean done;
}
