package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.test.type.Evaluation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckTest {

  Check sut;

  @ParameterizedTest
  @ValueSource(ints = {18, 100})
  void testIsAdultTrue(int x) {
    sut = new Check();

    assertTrue(sut.isAdult(x));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 17})
  void testIsAdultFalse(int x) {
    sut = new Check();

    assertFalse(sut.isAdult(x));
  }

  @ParameterizedTest
  @ValueSource(strings = {""})
  void testIsEmptyTrue(String str) {
    sut = new Check();

    assertTrue(sut.isEmpty(str));
  }

  @ParameterizedTest
  @ValueSource(strings = {"Hello", "null", " "})
  void testIsEmptyFalse(String str) {
    sut = new Check();

    assertFalse(sut.isEmpty(str));
  }

  @ParameterizedTest
  @CsvSource({
    "80,80,EXCELLENT",
    "79,80,GREAT",
    "79,79,GOOD",
  })
  void testEvaluate(int math, int eng, String expectedStr) {
    var expected = Evaluation.valueOf(expectedStr);
    sut = new Check();
    var actual = sut.evaluate(math, eng);
    assertEquals(expected, actual);
  }
}
