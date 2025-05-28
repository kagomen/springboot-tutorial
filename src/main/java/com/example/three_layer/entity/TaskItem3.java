package com.example.three_layer.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // DBテーブルとして扱うクラスであることをJPAに伝える
@Data
@NoArgsConstructor
public class TaskItem3 {

  @Schema(accessMode = Schema.AccessMode.READ_ONLY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private boolean done;
}
