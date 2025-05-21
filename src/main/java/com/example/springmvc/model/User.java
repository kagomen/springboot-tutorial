package com.example.springmvc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {

  @NotBlank(message = "名前は必須項目です")
  private String name;

  @Email(message = "正しい形式で入力してください")
  private String email;

  @Min(value = 0, message = "年齢は0以上で入力してください")
  @Max(value = 150, message = "年齢は150以下で入力してください")
  private int age;

  public User() {}

  public User(String name, String email, int age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
