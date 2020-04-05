package org.neu.java.stream;

import java.util.stream.Stream;

public class StreamBasic {
  private void noneMatchTest() {

    Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 10);


  }

  public static void main(String[] args) {
    StreamBasic inst = new StreamBasic();
    inst.noneMatchTest();
  }
}
