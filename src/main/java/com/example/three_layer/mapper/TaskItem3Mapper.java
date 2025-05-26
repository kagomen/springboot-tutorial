package com.example.three_layer.mapper;

import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3Response;
import com.example.three_layer.entity.TaskItem3;
import org.springframework.stereotype.Component;

@Component // Springがクラスをインスタンス化して保持してくれる
public class TaskItem3Mapper {
  // DTOからEntityに変換(対DB用)
  public TaskItem3 toEntity(TaskItem3Request req) {
    var entity = new TaskItem3();
    entity.setTitle(req.getTitle());
    entity.setDone(req.isDone());
    return entity;
  }

  // EntityからDTOに変換（対クライアント用）
  public TaskItem3Response toDTO(TaskItem3 entity) {
    var dto = new TaskItem3Response();
    dto.setId(entity.getId());
    dto.setTitle(entity.getTitle());
    dto.setDone(entity.isDone());
    return dto;
  }
}
