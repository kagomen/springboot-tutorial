package com.example.three_layer.controller;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TaskItemDTO {
  private String content;
  private LocalDateTime timestamp;
}
