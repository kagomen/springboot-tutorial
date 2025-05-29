package com.example.three_layer.mapper;

import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3Response;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.entity.TaskItem3;
import org.mapstruct.Mapper;

// MapStructが実装クラスを生成してくれる + @Component（Springがクラスをインスタンス化して保持してくれる）
@Mapper(componentModel = "spring")
public interface TaskItem3Mapper {
  // DTOからEntityに変換(対DB用)
  TaskItem3 toEntity(TaskItem3Request req);

  // DTOからEntityに変換(対DB用)
  TaskItem3 toEntity(Integer id, TaskItem3UpdateRequest req);

  // EntityからDTOに変換（対クライアント用）
  TaskItem3Response toDTO(TaskItem3 entity);
}
