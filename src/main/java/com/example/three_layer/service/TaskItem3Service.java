package com.example.three_layer.service;

import com.example.three_layer.dto.TaskItem3PatchRequest;
import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.entity.TaskItem3;
import java.util.List;

public interface TaskItem3Service {
  List<TaskItem3> findAll();

  TaskItem3 save(TaskItem3Request req);

  TaskItem3 update(Integer id, TaskItem3UpdateRequest req);

  TaskItem3 partialUpdate(Integer id, TaskItem3PatchRequest patchRequest);

  void deleteById(Integer id);
}
