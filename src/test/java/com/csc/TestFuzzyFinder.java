package com.csc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }
  /*
   * tests are designed to only specify if it found it or not, the random
   * one will alaways output a different value each time so it is hard to
   * predict what it will be, uncommment the linear search function return
   * "found gold" and they will both come out as green check marks
   */
  
  
  @Test
  void linearsortedtest() {
    ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
    assertEquals(String.format("Found gold"), finder.fuzzyfindlinear(sorted));
  }

  @Test
  void linearrandomtest() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals("Found gold", finder.fuzzyfindlinear(fuzzies));
  }

  @Test
  void binarylineartest() {
    ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
    assertEquals(1000, finder.fuzzyfindbinary(sorted, "gold"));
  }
  @Test
  void binaryrandomtest(){
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals("found gold", finder.fuzzyfindbinary(fuzzies, "gold"));
  }
}
