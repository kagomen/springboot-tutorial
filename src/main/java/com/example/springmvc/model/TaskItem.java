package com.example.springmvc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity // このクラスはDBテーブルとして管理される、という宣言
public class TaskItem {

  @Schema(accessMode = Schema.AccessMode.READ_ONLY) // データとしてidを持つが、POST時に指定できないようにする
  @Id // 主キー
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動でidを作成
  private Integer id;

  private String title;
  private boolean isDone;
}
