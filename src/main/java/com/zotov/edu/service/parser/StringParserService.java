package com.zotov.edu.service.parser;

import com.zotov.edu.service.calculate.CalculateService;
import com.zotov.edu.service.model.Operator;
import com.zotov.edu.service.model.PolishNotationStorage;

public class StringParserService implements ParserService {

  CalculateService calculateService;

  public StringParserService(CalculateService calculateService) {
    this.calculateService = calculateService;
  }

  @Override
  public String parseString(String expression) {
    PolishNotationStorage polishNotationStorage = this.parseHighPriorityOperations(expression);

    for (int i = 0; i < polishNotationStorage.getSize(); i++) {
      this.calculateService.calculateTwoLastDigits(polishNotationStorage);
    }

    return polishNotationStorage.getResult();
  }

  private PolishNotationStorage parseHighPriorityOperations(String expression) {
    PolishNotationStorage polishNotationStorage = new PolishNotationStorage();
    StringBuilder currentArg = new StringBuilder();
    for (char c : expression.toCharArray()) {
      if (!this.isOperator(c)) {
        currentArg.append(c);
      } else {
        polishNotationStorage.putDigit(Double.parseDouble(currentArg.toString()));
        currentArg = new StringBuilder();
        this.parseOperator(polishNotationStorage, this.getOperator(c));
      }
    }

    polishNotationStorage.putDigit(Double.parseDouble(currentArg.toString()));
    return polishNotationStorage;
  }

  private void parseOperator(PolishNotationStorage polishNotationStorage,
      Operator currentOperator) {
    if (!polishNotationStorage.isEmpty()) {
      if (polishNotationStorage.isLastOperatorHasMorePriority(currentOperator)) {
        this.calculateService.calculateTwoLastDigits(polishNotationStorage);
      }
    }
    polishNotationStorage.putOperator(currentOperator);
  }

  private Operator getOperator(char c) {
    for (Operator operator : Operator.values()) {
      if (operator.getSymbol() == c) {
        return operator;
      }
    }
    return null;
  }

  private boolean isOperator(char c) {
    for (Operator operator : Operator.values()) {
      if (operator.getSymbol() == c) {
        return true;
      }
    }
    return false;
  }

}
