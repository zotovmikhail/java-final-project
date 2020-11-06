package com.zotov.edu;

import com.zotov.edu.service.calculate.CalculateService;
import com.zotov.edu.service.calculate.SimpleCalculateService;
import com.zotov.edu.service.parser.ParserService;
import com.zotov.edu.service.parser.StringParserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParserServiceTest {

  ParserService parserService;

  @BeforeEach
  private void setup() {
    this.parserService = new StringParserService(new SimpleCalculateService());
  }

  @ParameterizedTest
  @MethodSource("com.zotov.edu.Providers#testParserService")
  public void testParserService(String expression, String expectedResult) {
    String actualResult = parserService.parseString(expression);
    Assertions.assertEquals(expectedResult, actualResult);
  }
}
