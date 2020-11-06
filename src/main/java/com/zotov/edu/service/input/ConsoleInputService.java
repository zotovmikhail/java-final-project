package com.zotov.edu.service.input;

import com.zotov.edu.exception.InvalidFloatNumberException;
import com.zotov.edu.service.parser.ParserService;
import com.zotov.edu.service.validator.ValidatorService;
import java.util.Scanner;

public class ConsoleInputService implements InputService {

  private static final String WHITE_SPACE_PATTERN = "\\s+";
  ValidatorService validatorService;

  ParserService parserService;

  public ConsoleInputService(ValidatorService validatorService,
      ParserService parserService) {
    this.validatorService = validatorService;
    this.parserService = parserService;
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Enter the expression:");
        String input = this.readInput();
        this.calculateAndDisplayResult(input);
      } catch (RuntimeException e) {
        e.printStackTrace();
      }
    }
  }

  private void calculateAndDisplayResult(String input) {
    System.out.println("The result: ");
    try {
      System.out.println(this.parserService.parseString(input) + "\n");
    } catch (NumberFormatException e) {
      throw new InvalidFloatNumberException(
          "Cannot parse digits to double. Please check the input");
    }
  }

  private String readInput() {
    String input = new Scanner(System.in).nextLine().replaceAll(WHITE_SPACE_PATTERN, "");
    this.validatorService.validateExpression(input);
    return input;
  }
}
