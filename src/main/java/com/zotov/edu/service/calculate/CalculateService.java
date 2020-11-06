package com.zotov.edu.service.calculate;

import com.zotov.edu.service.model.Operator;
import com.zotov.edu.service.model.PolishNotationStorage;

public interface CalculateService {
  Double doOperation(Double firstDigit, Double secondDigit, Operator operator);

  void calculateTwoLastDigits(PolishNotationStorage polishNotationStorage);
}
