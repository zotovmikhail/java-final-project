package com.zotov.edu.service.input;

import com.zotov.edu.service.parser.ParserService;
import com.zotov.edu.service.validator.ValidatorService;
import java.util.Scanner;

public class ConsoleInputService implements InputService {

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
      this.readInput();
    }
  }

  @Override
  public void readInput() {
    System.out.println("Enter the expression:");
    String input = new Scanner(System.in).nextLine();
    this.validatorService.validateExpression(input);
    System.out.println("The result: ");
    System.out.println(this.parserService.parseString(input) + "\n");
  }
}
