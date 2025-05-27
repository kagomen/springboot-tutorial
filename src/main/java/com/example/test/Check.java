package com.example.test;

public class Check {
  public boolean isAdult(int x) {
    if (x >= 18) return true;

    return false;
  }

  public boolean isEmpty(String str) {
    return str.isEmpty();
  }

  public String evaluate(int mathScore, int englishScore) {
    if (mathScore >= 80 && englishScore >= 80) return "excellent";
    if (mathScore >= 80 || englishScore >= 80) return "very good";
    return "good";
  }
}
