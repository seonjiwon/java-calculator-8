package calculator.service;


import calculator.exception.ErrorMessage;
import calculator.model.Numbers;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberParserTest {

    private final NumberParser numberParser = new SimpleNumberParser();

    @Test
    @DisplayName("올바른 숫자 배열을 반환한다.")
    void returnNumbers() throws Exception{
        // given
        String input = "1, 2, 3";
        String delimiter = ",";

        // when
        Numbers parsedNumber = numberParser.parse(input, delimiter);

        // then
        assertThat(parsedNumber).isEqualTo(new Numbers(List.of(1, 2, 3)));
    }
    
    @Test
    @DisplayName("null 값이 들어왔을 경우 빈 배열이 반환된다.")
    void returnsEmptyListWhenInputIsNull() throws Exception{
        // given
        String input = null;
        String delimiter = "ANY_DELIMITER";
        
        // when
        Numbers result = numberParser.parse(input, delimiter);

        // then
        assertThat(result).isEqualTo(Numbers.empty());
    }

    @Test
    @DisplayName("빈 값이 들어왔을 경우 빈 배열이 반환된다.")
    void returnsEmptyListWhenInputIsEmpty() throws Exception{
        // given
        String input = "";
        String delimiter = "ANY_DELIMITER";

        // when
        Numbers result = numberParser.parse(input, delimiter);

        // then
        assertThat(result).isEqualTo(Numbers.empty());
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력시 예외가 발생한다.")
    void occurExceptionWhenInputIsNotInteger() throws Exception{
        // given
        String input = "NOT_INTEGER, 1, 2";
        String delimiter = ",";

        // when, then
        assertThatThrownBy(() -> numberParser.parse(input, delimiter))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("음수가 주어질 경우 예외가 발생한다.")
    void occurExceptionWhenInputIsNegativeValue() throws Exception{
        // given
        String input = "-1, 1, 2";
        String delimiter = ",";

        // when, then
        assertThatThrownBy(() -> numberParser.parse(input, delimiter))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
    }
}