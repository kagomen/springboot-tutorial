package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalcTest {

  Calc sut;

  @BeforeEach
  void setUp() throws Exception {
    sut = new Calc();
  }

  @Test
  @DisplayName("正常系: add")
  void testAdd() {
    int actual = sut.add(7, 3);
    int expected = 10;

    assertEquals(actual, expected);
  }

  @Test
  @DisplayName("正常系: divide")
  void testDivide() {
    int actual = sut.divide(10, 2);
    int expected = 5;

    assertEquals(actual, expected);
  }

  @Test
  @DisplayName("異常系: divide")
  void testDivideThrowIllegalArgumentException() {
    String expected = "0で割れない";

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> sut.divide(5, 0));

    assertEquals(expected, e.getMessage());
  }
}
