package calculator.view;

public class OutputView {

    private final static String RESULT_PROMPT = "결과 : ";
    private final static String ERROR_PROMPT = "[ERROR] ";

    public void printResult(int result) {
        System.out.println(RESULT_PROMPT + result);
    }

    public void printErrorMessage(String message) {
        System.err.println(ERROR_PROMPT + message);
    }

}
