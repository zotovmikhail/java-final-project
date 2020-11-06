package com.zotov.edu;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class Providers {

  public Providers() {
  }

  public static Stream<Arguments> testParserService() {
    return Stream.of(
        Arguments.arguments("1+2*3-4", "3.0"),
        Arguments.arguments("14/2*3-4.0", "17.0"),
        Arguments.arguments("14.5-0.2", "14.3"),
        Arguments.arguments("1+1*1*1/1-1-1+1+1", "2.0")
    );
  }
}
