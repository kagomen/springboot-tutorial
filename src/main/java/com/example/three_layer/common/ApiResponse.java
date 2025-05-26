package com.example.three_layer.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
  private boolean success;
  private T data;

  public static <T> ApiResponse<T> ok(T data) {
    return new ApiResponse<>(true, data);
  }
}
