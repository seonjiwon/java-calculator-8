package calculator.service;

import calculator.model.Numbers;

public class SimpleCalculator implements Calculator {

    private final DelimiterExtractor delimiterExtractor;
    private final NumberParser numberParser;

    public SimpleCalculator() {
        this.delimiterExtractor = new SimpleDelimiterExtractor();
        this.numberParser = new SimpleNumberParser();
    }

    @Override
    public int calculate(String input) {
        // 유효성 체크
        if (isNullOrEmpty(input)) {
            return 0;
        }

        // delimiter 추출
        String delimiter = delimiterExtractor.extract(input);
        String numberPart = delimiterExtractor.removeDelimiter(input);

        // 숫자 파싱
        Numbers numbers = numberParser.parse(numberPart, delimiter);

        // 계산
        return sum(numbers);
    }

    private int sum(Numbers numbers) {
        return 0;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
