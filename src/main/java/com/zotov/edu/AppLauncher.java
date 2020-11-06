package com.zotov.edu;

import com.zotov.edu.service.calculate.CalculateService;
import com.zotov.edu.service.calculate.SimpleCalculateService;
import com.zotov.edu.service.input.ConsoleInputService;
import com.zotov.edu.service.parser.ParserService;
import com.zotov.edu.service.parser.StringParserService;
import com.zotov.edu.service.validator.ConsoleValidator;
import com.zotov.edu.service.validator.ValidatorService;

public class AppLauncher {

  public static void main(String[] args) {
    ValidatorService validatorService = new ConsoleValidator();
    CalculateService calculateService = new SimpleCalculateService();
    ParserService parserService = new StringParserService(calculateService);

    new ConsoleInputService(validatorService, parserService).run();
  }
}
