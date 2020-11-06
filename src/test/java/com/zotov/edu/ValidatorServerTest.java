package com.zotov.edu;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.zotov.edu.service.exception.InvalidInputException;
import com.zotov.edu.service.exception.InvalidOperatorsOrderException;
import com.zotov.edu.service.exception.MultipleOperationsException;
import com.zotov.edu.service.validator.ConsoleValidator;
import com.zotov.edu.service.validator.ValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorServerTest {

  ValidatorService validatorService;

  @BeforeEach
  public void setup() {
    this.validatorService = new ConsoleValidator();
  }

  @ParameterizedTest
  @MethodSource("com.zotov.edu.Providers#testInvalidInput")
  public void testInvalidInput(String expression) {
    assertThrows(InvalidInputException.class,
        () -> this.validatorService.validateExpression(expression));
  }

  @ParameterizedTest
  @MethodSource("com.zotov.edu.Providers#testMultipleOperators")
  public void testMultipleOperators(String expression) {
    assertThrows(MultipleOperationsException.class,
        () -> this.validatorService.validateExpression(expression));
  }

  @ParameterizedTest
  @MethodSource("com.zotov.edu.Providers#testInvalidOperatorsOrder")
  public void testInvalidOperatorsOrder(String expression) {
    assertThrows(InvalidOperatorsOrderException.class,
        () -> this.validatorService.validateExpression(expression));
  }
}
