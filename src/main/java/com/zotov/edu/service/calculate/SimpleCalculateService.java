package com.zotov.edu.service.calculate;

import com.zotov.edu.exception.InvalidOperationException;
import com.zotov.edu.exception.UnknownOperatorException;
import com.zotov.edu.model.Operator;
import com.zotov.edu.model.PolishNotationStorage;

public class SimpleCalculateService implements CalculateService {

  public SimpleCalculateService() {
  }

  @Override
  public Double doOperation(Double firstDigit, Double secondDigit, Operator operator) {
    switch (operator) {
      case PLUS:
        return firstDigit + secondDigit;
      case MINUS:
        return firstDigit - secondDigit;
      case OBELUS:
        if (secondDigit == 0) {
          throw new InvalidOperationException("The second operand should not be 0 when division");
        }
        return firstDigit / secondDigit;
      case TIMES:
        return firstDigit * secondDigit;
    }

    throw new UnknownOperatorException("Please add the case for operator: " + operator.getSymbol());
  }

  @Override
  public void calculateTwoLastDigits(PolishNotationStorage polishNotationStorage) {
    Double[] twoLastDigits = polishNotationStorage.getTwoLastDigits();
    Operator operator = polishNotationStorage.popLastOperator();
    Double result = this.doOperation(twoLastDigits[1], twoLastDigits[0], operator);
    polishNotationStorage.putDigit(result);
  }
}
