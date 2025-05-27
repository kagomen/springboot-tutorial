package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    "80,80,excellent",
    "79,80,very good",
    "79,79,good",
  })
  void testEvaluate(int math, int eng, String expected) {
    sut = new Check();
    String actual = sut.evaluate(math, eng);
    assertEquals(actual, expected);
  }
}
