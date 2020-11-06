package com.zotov.edu.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotationStorage {

  private Stack<Operator> stack = new Stack<>();

  private Stack<Double> digits = new Stack<>();

  public PolishNotationStorage() {
  }

  public Operator popLastOperator() {
    return this.stack.pop();
  }

  public Operator peekLastOperator() {
    return this.stack.peek();
  }

  public void putOperator(Operator operator) {
    this.stack.push(operator);
  }

  public Double[] getTwoLastDigits() {
    Double[] digits = new Double[2];
    digits[0] = this.digits.pop();
    digits[1] = this.digits.pop();
    return digits;
  }


  public void putDigit(Double digit) {
    this.digits.push(digit);
  }

  public int getSize() {
    return this.digits.size();
  }

  public boolean isEmpty() {
    return this.stack.isEmpty();
  }

  public double getLastDigit() {
    return this.digits.pop();
  }

  public boolean isLastOperatorHasMorePriority(Operator currentOperator) {
    return currentOperator.getPriority() <= this.peekLastOperator()
        .getPriority();
  }

  public String getResult() {
    return String.valueOf(this.getLastDigit());
  }
}
