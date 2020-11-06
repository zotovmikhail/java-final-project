package com.zotov.edu.service.calculate;

import static com.zotov.edu.service.model.Operator.PLUS;

import com.zotov.edu.service.model.Operator;
import com.zotov.edu.service.model.PolishNotationStorage;

public class SimpleCalculateService implements CalculateService {

  public SimpleCalculateService() {
  }

  @Override
  public Double doOperation(Double firstDigit, Double secondDigit, Operator operator) {
    if (operator == Operator.PLUS) {
      return firstDigit + secondDigit;
    }
    if (operator == Operator.MINUS) {
      return firstDigit - secondDigit;
    }
    if (operator == Operator.OBELUS) {
      return firstDigit / secondDigit;
    }
    if (operator == Operator.TIMES) {
      return firstDigit * secondDigit;
    }
    return (double) 0;
  }

  @Override
  public void calculateTwoLastDigits(PolishNotationStorage polishNotationStorage) {
    Double[] twoLastDigits = polishNotationStorage.getTwoLastDigits();
    Operator operator = polishNotationStorage.popLastOperator();
    Double result = this.doOperation(twoLastDigits[1], twoLastDigits[0], operator);
    polishNotationStorage.putDigit(result);
  }
}
