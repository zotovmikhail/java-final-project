package com.zotov.edu.model;

import java.util.Stack;

public class PolishNotationStorage {

  private final Stack<Operator> stack = new Stack<>();

  private final Stack<Double> digits = new Stack<>();

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

  public int getNumberOfDigits() {
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

  public boolean hasOperators() {
    return !this.stack.empty();
  }
}
