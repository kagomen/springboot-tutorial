package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalcTest {

  Calc sut;

  @Test
  @DisplayName("add: 正常系")
  void testAdd() {
    sut = new Calc();

    int actual = sut.add(7, 3);
    int expected = 10;

    assertEquals(actual, expected);
  }

  @Test
  @DisplayName("divide: 正常系")
  void testDivide() {
    sut = new Calc();

    int actual = sut.divide(10, 2);
    int expected = 5;

    assertEquals(actual, expected);
  }

  @Test
  @DisplayName("divide: 異常系")
  void testDivideThrowIllegalArgumentException() {
    sut = new Calc();

    String expected = "0で割れない";

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> sut.divide(5, 0));

    assertEquals(expected, e.getMessage());
  }
}
