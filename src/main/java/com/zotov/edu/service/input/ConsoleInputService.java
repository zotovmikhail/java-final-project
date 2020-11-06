package com.zotov.edu.service.input;

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
        this.readInput();
      } catch (RuntimeException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void readInput() throws RuntimeException {
    System.out.println("Enter the expression:");
    String input = new Scanner(System.in).nextLine().replaceAll(WHITE_SPACE_PATTERN, "");
    this.validatorService.validateExpression(input);
    System.out.println("The result: ");
    System.out.println(this.parserService.parseString(input) + "\n");
  }
}
