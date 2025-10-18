package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new SimpleCalculator();

    @Test
    @DisplayName("기본 구분자 입력시 제대로 수행된다.")
    void calculateSuccessfulWhenInputIsDefaultDelimiter() throws Exception{
        // given
        String input = "1,2,3";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 입력시 제대로 계산이 수행된다.")
    void calculateSuccessfulWhenInputIsCustomDelimiter() throws Exception{
        // given
        String input = "//[\\n1[2[3";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀, 정규 구분자 혼합 입력시 제대로 계산이 수행된다.")
    void calculateSuccessfulWhenInputIsDefaultAndCustomDelimiter() throws Exception{
        // given
        String input = "//*\\n1,2*3";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("null 값 입력시 0이 반환된다.")
    void returnZeroWhenInputIsNull() throws Exception{
        // given
        String input = null;

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("공백 값 입력시 0이 반환된다.")
    void returnZeroWhenInputIsEmpty() throws Exception{
        // given
        String input = "";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }
}