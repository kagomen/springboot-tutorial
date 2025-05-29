package com.example.three_layer.common;

import java.util.Map;
import lombok.Data;

@Data
public class ApiErrorResponse {
  private final boolean isSuccess = false;
  private final String error;
  private final Map<String, String> errors;

  private ApiErrorResponse(String error, Map<String, String> errors) {
    this.error = error;
    this.errors = errors;
  }

  // 単一エラー
  public static ApiErrorResponse of(String errorMessage) {
    return new ApiErrorResponse(errorMessage, null);
  }

  // 複数エラー
  public static ApiErrorResponse of(Map<String, String> errors) {
    return new ApiErrorResponse(null, errors);
  }
}
