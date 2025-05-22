package com.example.springmvc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 引数なしコンストラクタを生成
public class User {

  @NotBlank private String name;

  @Email private String email;

  @Min(0)
  @Max(150)
  private int age;

  @NotBlank private String gender;

  private List<String> interests;

  public User(String name, String email, int age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }
}