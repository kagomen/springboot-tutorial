package com.example.three_layer.service;

import com.example.three_layer.entity.TaskItem3;
import com.example.three_layer.exception.TaskItem3NotFoundException;
import com.example.three_layer.repository.TaskItem3Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service層の実装クラスであること・DIの対象であることをSpringに伝える
public class TaskItem3ServiceImpl implements TaskItem3Service {

  private final TaskItem3Repository repository;

  @Autowired // コンストラクタインジェクション
  public TaskItem3ServiceImpl(TaskItem3Repository repository) {
    this.repository = repository;
  }

  @Override
  public List<TaskItem3> findAll() {
    return repository.findAll();
  }

  @Override
  public TaskItem3 save(TaskItem3 taskItem) {
    return repository.save(taskItem);
  }

  @Override
  public TaskItem3 update(Integer id, TaskItem3 updateTaskItem) {
    TaskItem3 taskItem =
        repository.findById(id).orElseThrow(() -> new TaskItem3NotFoundException());

    taskItem.setTitle(updateTaskItem.getTitle());
    taskItem.setDone(updateTaskItem.isDone());

    return repository.save(taskItem);
  }

  @Override
  public void deleteById(Integer id) {
    repository.deleteById(id);
  }
}
