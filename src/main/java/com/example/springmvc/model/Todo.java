package com.example.springmvc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Todo {
  @Schema(accessMode = Schema.AccessMode.READ_ONLY) // データとしてidを持つが、POST時に指定できないようにする
  private Integer id;

  private String title;
  private boolean done;
}
