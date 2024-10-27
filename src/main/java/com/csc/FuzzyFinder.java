package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {

  public static void main(String args[]) {
    FuzzyFinder finder = new FuzzyFinder();
    FuzzyListGenerator generator = new FuzzyListGenerator();

    ArrayList<Fuzzy> randomfuzzies = generator.randomizedRainbowFuzzies();
    ArrayList<Fuzzy> sortedfuzzies = generator.sortedRainbowFuzzies();

    System.out.println(finder.fuzzyfindlinear(sortedfuzzies));
    System.out.print(finder.fuzzyfindbinary(randomfuzzies, "gold"));

  }

  public String fuzzyfindlinear(ArrayList<Fuzzy> list) {
    for (int i = 0; i < list.size(); i++) {
      String c = list.get(i).color;
      if ("gold".equals(c))
        return "Found gold at:" + i;
      // uncomment "return Found gold" and comment out "found gold at:" and tests will
      // be green
      // return "Found gold";
    }
    return "not found";
  }

  public int fuzzyfindbinary(ArrayList<Fuzzy> sortedArray, String key) {
    int low = 0;
    int high = sortedArray.size() - 1;
    while (high >= 1) {
      int mid = low + (high - low) / 2;
      String target = sortedArray.get(mid).color;
      int index = 1000;
      if (key.equals(target))
        return mid;
      else if (index > mid)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return -1;
  }
}
