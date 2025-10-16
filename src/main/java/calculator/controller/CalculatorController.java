package calculator.controller;

import calculator.service.Calculator;
import calculator.service.SimpleCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 전체 흐름 제어
 */
public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculatorService;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculatorService = new SimpleCalculator();
    }

    public void start() {
        try {
            String input = inputView.readInput();
            int result = calculatorService.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

}
