package com.zotov.edu.service.parser;

import com.zotov.edu.service.calculate.CalculateService;
import com.zotov.edu.model.Operator;
import com.zotov.edu.model.PolishNotationStorage;

public class StringParserService implements ParserService {

  CalculateService calculateService;

  public StringParserService(CalculateService calculateService) {
    this.calculateService = calculateService;
  }

  @Override
  public String parseString(String expression) {
    PolishNotationStorage polishNotationStorage = this.parseHighPriorityOperations(expression);

    if (polishNotationStorage.hasOperators()) {
      this.parseLowPriorityOperations(polishNotationStorage);
    }

    return polishNotationStorage.getResult();
  }

  private void parseLowPriorityOperations(PolishNotationStorage polishNotationStorage) {
    for (int i = 0; i < polishNotationStorage.getNumberOfDigits(); i++) {
      this.calculateService.calculateTwoLastDigits(polishNotationStorage);
    }
  }

  private PolishNotationStorage parseHighPriorityOperations(String expression) {
    PolishNotationStorage polishNotationStorage = new PolishNotationStorage();
    StringBuilder currentArg = new StringBuilder();
    for (char c : expression.toCharArray()) {
      if (!Operator.isOperator(c)) {
        currentArg.append(c);
      } else {
        polishNotationStorage.putDigit(Double.parseDouble(currentArg.toString()));
        currentArg = new StringBuilder();
        this.parseOperator(polishNotationStorage, Operator.getOperator(c));
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

}
