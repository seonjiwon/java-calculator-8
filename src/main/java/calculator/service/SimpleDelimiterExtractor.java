package calculator.service;

import calculator.exception.ErrorMessage;
import java.util.regex.Pattern;

public class SimpleDelimiterExtractor implements DelimiterExtractor{

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITER = ",|:";

    private static final String ALLOWED_CUSTOM_DELIMITER = "~!@#$%^&*()_+`={}[];<>?";

    @Override
    public String extract(String input) {
        // 커스텀 구분자가 있는 경우
        if (hasCustomDelimiter(input)) {
            return DEFAULT_DELIMITER + "|" + extractCustomDelimiter(input);
        }

        return DEFAULT_DELIMITER;
    }

    @Override
    public String removeDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int delimiterEndIndex =
                input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
            return input.substring(delimiterEndIndex);
        }
        return input;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        String customDelimiter = input.substring(startIndex, endIndex);
        validateCustomDelimiter(customDelimiter);

        return escapeRegex(customDelimiter);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
        }

        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_LENGTH.getMessage());
        }

        // 커스텀 구분자가 기본 구분자일 경우 그냥 패스
        if (DEFAULT_DELIMITER.contains(customDelimiter)) {
            return;
        }

        if (!ALLOWED_CUSTOM_DELIMITER.contains(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER.getMessage() + ALLOWED_CUSTOM_DELIMITER);
        }
    }

    private String escapeRegex(String customDelimiter) {
        return Pattern.quote(customDelimiter);
    }
}
