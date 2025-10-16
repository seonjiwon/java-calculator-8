package calculator.exception;

public enum ErrorMessage {

    // 구분자 관련
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자는 비어있을 수 없습니다."),

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
