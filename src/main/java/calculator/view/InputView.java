package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력 담당
 */
public class InputView {

    private final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public String readInput() {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }
}
