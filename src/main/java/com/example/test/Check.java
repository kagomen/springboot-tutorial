package com.example.test;

import com.example.test.type.Evaluation;

public class Check {
  final int ADULT = 18;
  final int HIGH_SCORE = 80;

  public boolean isAdult(int x) {
    return x >= ADULT;
  }

  public boolean isEmpty(String str) {
    return str.isEmpty();
  }

  public Evaluation evaluate(int mathScore, int englishScore) {
    if (mathScore >= HIGH_SCORE && englishScore >= HIGH_SCORE) return Evaluation.EXCELLENT;
    if (mathScore >= HIGH_SCORE || englishScore >= HIGH_SCORE) return Evaluation.GREAT;
    return Evaluation.GOOD;
  }
}
