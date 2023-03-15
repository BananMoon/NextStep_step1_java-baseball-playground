package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 사용자 입력 예외 처리 유틸 클래스
 *     1~9 사이에 있는가?
 *     3글자인가?
 *     중복 값이 있는가?
 */
public class ValidationUtilsTest {

    /**
     * Tip : 테스트 시 가장자리 값을 테스트한다.
     */
    @ParameterizedTest
    @MethodSource("provideInputNo")
    void 야구숫자_1_9_사이_검증 (int inputNo, boolean expected) {
        boolean result = ValidationUtils.isValidNo(inputNo);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> provideInputNo() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(10, false),
                Arguments.of(9, true),
                Arguments.of(0, false)
        );
    }

}
