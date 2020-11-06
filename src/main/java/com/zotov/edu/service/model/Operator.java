package com.zotov.edu.service.model;

import java.util.ArrayList;
import java.util.List;

public enum Operator {
  PLUS('+', 1),
  MINUS('-', 1),
  OBELUS('/', 2),
  TIMES('*', 2);

  char symbol;
  int priority;

  Operator(char symbol, int priority) {
    this.symbol = symbol;
    this.priority = priority;
  }

  public char getSymbol() {
    return symbol;
  }

  public int getPriority() {
    return priority;
  }

  public static List<Character> getAvailableOperators() {
    List<Character> availableOperators = new ArrayList<>();
    for (Operator operator : Operator.values()) {
      availableOperators.add(operator.getSymbol());
    }
    return availableOperators;
  }

  public static Operator getOperator(char c) {
    for (Operator operator : Operator.values()) {
      if (operator.getSymbol() == c) {
        return operator;
      }
    }
    return null;
  }

  public static boolean isOperator(char c) {
    for (Operator operator : Operator.values()) {
      if (operator.getSymbol() == c) {
        return true;
      }
    }
    return false;
  }
}
