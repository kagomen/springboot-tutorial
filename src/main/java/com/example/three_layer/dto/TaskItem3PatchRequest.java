package com.example.three_layer.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

// 1項目だけのリクエストでも変更を受け入れられるように、nullを許容する
@Data
public class TaskItem3PatchRequest {
  // @NotBlackをつけずにnullを許容
  @Size(max = 100, message = "100文字以内で入力してください")
  private String title;

  private Boolean isDone; // Booleanにすることでnullを許容
}
