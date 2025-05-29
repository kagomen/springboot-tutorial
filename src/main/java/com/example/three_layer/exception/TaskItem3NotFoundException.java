package com.example.three_layer.exception;

public class TaskItem3NotFoundException extends RuntimeException {
  public TaskItem3NotFoundException() {
    super("指定されたタスクは存在しません");
  }
}
