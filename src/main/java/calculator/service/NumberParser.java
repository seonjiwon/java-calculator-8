package calculator.service;

import calculator.model.Numbers;

/**
 * 숫자 변환 담당
 */
public interface NumberParser {
    Numbers parse(String input, String delimiter);
}
