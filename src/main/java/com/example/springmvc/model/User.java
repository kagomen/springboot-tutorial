package com.example.springmvc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class User {

  @NotBlank private String name;

  @Email private String email;

  @Min(0)
  @Max(150)
  private int age;

  @NotBlank private String gender;

  private List<String> interests;

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

  public String getGender() {
    return gender;
  }

  public List<String> getInterests() {
    return interests;
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

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }
}
