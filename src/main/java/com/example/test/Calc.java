package com.example.test;

public class Calc {
  public int add(int x, int y) {
    return x + y;
  }

  public int divide(int x, int y) {
    if (y == 0) throw new IllegalArgumentException("0で割れない");
    return x / y;
  }
}
