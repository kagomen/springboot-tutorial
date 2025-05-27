package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleForLifeCycleTest {

  SampleForLifeCycle sut;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {

    System.out.println("BeforeAllの実行");
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    System.out.println("AfterAllの実行");
  }

  @BeforeEach
  void setUp() throws Exception {
    sut = new SampleForLifeCycle();
    System.out.println("BeforeEachの実行");
  }

  @AfterEach
  void tearDown() throws Exception {
    System.out.println("AfterEachの実行");
  }

  @Test
  void testSample() {
    String expected = "テストメソッドの実行";
    String actual = sut.sample();

    assertEquals(expected, actual);

    System.out.println("testSampleの実行");
  }

  @Test
  void testSample2() {
    String expected = "テストメソッドの実行";
    String actual = sut.sample();

    assertEquals(expected, actual);

    System.out.println("testSample2の実行");
  }
}
