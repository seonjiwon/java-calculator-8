package calculator.exception;

public enum ErrorMessage {

    // 구분자 관련
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자는 비어있을 수 없습니다."),
    INVALID_CUSTOM_DELIMITER_LENGTH("커스텀 구분자는 한 글자를 넘을 수 없습니다."),
    INVALID_CUSTOM_DELIMITER("사용 가능한 커스텀 구분자 목록은 다음과 같습니다."),

    // 숫자 파싱 관련
    INVALID_NUMBER_FORMAT("숫자가 아닌 값이 포함되어 있습니다"),
    NEGATIVE_NUMBER_NOT_ALLOWED("숫자는 음수가 될 수 없습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
