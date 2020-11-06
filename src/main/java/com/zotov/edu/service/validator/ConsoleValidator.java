package com.zotov.edu.service.validator;

import com.zotov.edu.exception.InvalidInputException;
import com.zotov.edu.exception.InvalidOperatorsOrderException;
import com.zotov.edu.exception.MultipleOperationsException;
import com.zotov.edu.model.Operator;
import java.util.regex.Pattern;

public class ConsoleValidator implements ValidatorService {

  private static final char FLOAT_POINT = '.';

  private static final String FLOAT_DIGITS_PATTERN = "[0-9.]*";

  public ConsoleValidator() {
  }

  @Override
  public void validateExpression(String expression) {
    this
        .validateOnlyDigitsAndOperators(expression)
        .validateMultipleOperators(expression)
        .validateOperationsOrder(expression);
  }

  private ConsoleValidator validateOperationsOrder(String expression) {
    char[] symbols = expression.toCharArray();
    if (Operator.isOperator(symbols[0])
        || Operator.isOperator(symbols[symbols.length - 1])) {
      throw new InvalidOperatorsOrderException(
          "The expression should not contain operators at the beginning or at the end of the expression");
    }

    return this;
  }

  private ConsoleValidator validateMultipleOperators(String expression) {
    char previousChar = 0;
    for (char currentChar : expression.toCharArray()) {
      if (Operator.isOperator(currentChar)) {
        if (Operator.isOperator(previousChar)) {
          throw new MultipleOperationsException(
              "The expression should not contain multiple operators in a line, but contains: "
                  + previousChar + currentChar);
        }
      }
      previousChar = currentChar;
    }
    return this;
  }

  private ConsoleValidator validateOnlyDigitsAndOperators(String expression) {
    for (char c : expression.toCharArray()) {
      if (!Pattern.matches(FLOAT_DIGITS_PATTERN, String.valueOf(c))
          && !Operator.getAvailableOperators().contains(c)) {
        throw new InvalidInputException("The expression should contain only digits and operations."
            + " But the expression contains: " + c);
      }
    }

    return this;
  }

}
