package calculator.service;

/**
 * 구분자 관리 담당
 */
public interface DelimiterExtractor {

    String extract(String input);

    String removeDelimiter(String input);
}
