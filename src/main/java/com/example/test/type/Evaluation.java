package com.example.test.type;

public enum Evaluation {
  EXCELLENT("excellent"),
  GREAT("great"),
  GOOD("good");

  private final String label;

  Evaluation(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }

  public String getLabel() {
    return label;
  }
}
