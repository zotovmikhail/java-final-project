package com.zotov.edu.service.model;

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
}
