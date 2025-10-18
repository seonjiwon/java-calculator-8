package calculator.service;

import calculator.exception.ErrorMessage;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterExtractorTest {

    private final DelimiterExtractor extractor = new SimpleDelimiterExtractor();

    private static final String DEFAULT_DELIMITER = ",|:";

    @Test
    @DisplayName("기본 구분자를 반환한다.")
    void extractDefaultDelimiter() throws Exception{
        // given
        String input = "1:2:3";

        // when
        String extractedDelimiter = extractor.extract(input);

        // then
        assertThat(extractedDelimiter)
            .isEqualTo(DEFAULT_DELIMITER);
    }

    @Test
    @DisplayName("커스텀 구분자를 반환한다.")
    void extractCustomDelimiter() throws Exception{
        // given
        String input = "//[\\n1;2;3";

        // when
        String extractedDelimiter = extractor.extract(input);

        // then
        assertThat(extractedDelimiter)
            .isEqualTo(DEFAULT_DELIMITER + "|" + Pattern.quote("["));
    }

    @Test
    @DisplayName("커스텀 구분자가 비어 있는 경우 예외를 발생시킨다.")
    void emptyCustomDelimiterOccurException() throws Exception{
        // given
        String input = "//\\n1,2,3";
        // when, then
        assertThatThrownBy(() -> extractor.extract(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("기본 구분자 문장을 넣었을 경우 그대로 반환한다.")
    void removeDelimiterWithDefaultDelimiter() throws Exception{
        // given
        String input = "1,2,3";

        // when
        String result = extractor.removeDelimiter(input);

        // then
        assertThat(result).isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 문장을 넣었을 경우 제거해서 반환한다.")
    void removeDelimiterWithCustomDelimiter() throws Exception{
        // given
        String input = "//[\\n1;2;3";

        // when
        String result = extractor.removeDelimiter(input);

        // then
        assertThat(result).isEqualTo("1;2;3");
    }
}
