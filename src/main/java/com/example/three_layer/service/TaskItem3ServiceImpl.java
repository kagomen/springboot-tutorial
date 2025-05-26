package com.example.three_layer.service;

import com.example.three_layer.dto.TaskItem3PatchRequest;
import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.entity.TaskItem3;
import com.example.three_layer.exception.TaskItem3NotFoundException;
import com.example.three_layer.mapper.TaskItem3Mapper;
import com.example.three_layer.repository.TaskItem3Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service層の実装クラスであること・DIの対象であることをSpringに伝える
public class TaskItem3ServiceImpl implements TaskItem3Service {

  private final TaskItem3Repository repository;
  private final TaskItem3Mapper mapper;

  @Autowired // コンストラクタインジェクション
  public TaskItem3ServiceImpl(TaskItem3Repository repository, TaskItem3Mapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<TaskItem3> findAll() {
    return repository.findAll();
  }

  @Override
  public TaskItem3 save(TaskItem3Request req) {
    return repository.save(mapper.toEntity(req));
  }

  @Override
  public TaskItem3 update(Integer id, TaskItem3UpdateRequest req) {
    TaskItem3 taskItem =
        repository.findById(id).orElseThrow(() -> new TaskItem3NotFoundException());

    taskItem.setTitle(req.getTitle());
    taskItem.setDone(req.isDone());

    return repository.save(taskItem);
  }

  @Override
  public TaskItem3 partialUpdate(Integer id, TaskItem3PatchRequest req) {
    TaskItem3 taskItem =
        repository.findById(id).orElseThrow(() -> new TaskItem3NotFoundException());

    if (req.getTitle() != null) {
      taskItem.setTitle(req.getTitle());
    }
    if (req.getDone() != null) {
      taskItem.setDone(req.getDone());
    }

    return repository.save(taskItem);
  }

  @Override
  public void deleteById(Integer id) {
    repository.deleteById(id);
  }
}
