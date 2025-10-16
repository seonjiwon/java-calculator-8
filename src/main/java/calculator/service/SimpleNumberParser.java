package calculator.service;

import calculator.model.Numbers;
import java.util.Arrays;
import java.util.List;

public class SimpleNumberParser implements NumberParser{

    public Numbers parse(String numberPart, String delimiter) {
        if (numberPart == null || numberPart.isEmpty()) {
            return Numbers.empty();
        }

        // 구분자로 쪼개기
        String[] tokens = numberPart.split(delimiter);

        // 숫자로 변환
        List<Integer> numbers = convertToNumber(tokens);

        return new Numbers(numbers);
    }

    private List<Integer> convertToNumber(String[] tokens) {
        return Arrays.stream(tokens)
                     .map(String::trim)
                     .map(this::parseNumber)
                     .toList();
    }

    private int parseNumber(String string) {
        int number = parseInteger(string);
        validatePositive(number);

        return number;
    }

    private int parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("숫자는 음수가 될 수 없습니다.");
        }
    }
}
