package com.example.three_layer.service;

import com.example.three_layer.entity.TaskItem3;
import java.util.List;

public interface TaskItem3Service {
  List<TaskItem3> findAll();

  TaskItem3 save(TaskItem3 taskItem);

  void deleteById(Integer id);
}
