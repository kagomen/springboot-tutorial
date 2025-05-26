package com.example.three_layer.handler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 例外をアプリ全体でまとめて処理できるようにする
public class GlobalExceptionHandler {

  // リクエストのバリデーション失敗時
  @ExceptionHandler(
      MethodArgumentNotValidException.class) // MethodArgumentNotValidException型の例外が発生したときだけ発火
  public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return ResponseEntity.badRequest().body(errors);
  }
}
