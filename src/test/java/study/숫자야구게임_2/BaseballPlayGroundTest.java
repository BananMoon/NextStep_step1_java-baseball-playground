package study.숫자야구게임_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 했지만
 *   Input 테스트 - getCompareResultTest()
 *   Output 테스트 - System 설정을 통해 제어하지는 못함.
 *   result를 print하는 로직을 메서드 추출한다면 Output 테스트 또한 가능하겠지만
 *   본인은 guessAnswerUntilCorrect() 메서드를 실행하면서 true, false를 체크하였다.
 *   - why? 올바른 값이 나와야 올바른 boolean 값을 반환하고, 그 사이에 Output 로직이 있기 때문에
 *  boolean 값만 비교 체크하였다.
 */

class BaseballPlayGroundTest {

    @Test
    @DisplayName("정답은 3자리여야 한다.")
    void setNumberTest() {
        List<String> answer = BaseballPlayGround.setNumber();
        assertEquals(answer.size(), 3);
    }

    // input(String 배열)과 예측(Map<String, Integer>) 을 넣고, 결과와 예측값 비교
    // @ParameterizedTest를 통해 선언 로직을 분리하고, 각 다른 인자들 모두 테스트할 수 있다.
    @ParameterizedTest
    @MethodSource("provideHashMapOfResult")
    @DisplayName("같은 수&같은 위치는 스트라이크, 같은 수가 있기만 하면 볼, 전혀 없으면 낫싱")
    void getCompareResultTest(String[] input, Map<String, Integer> expected) {
        List<String> answer = List.of("7","1","3");
        Map<String, Integer> result = BaseballPlayGround.getCompareResult(answer, input);
        assertAll(
                () -> assertEquals(expected.size(), result.size()),
                () -> assertEquals(expected.get("스트라이크"), result.get("스트라이크")),
                () -> assertEquals(expected.get("볼"), result.get("볼"))
        );
    }
    static Stream<Arguments> provideHashMapOfResult() {
        return Stream.of(
                Arguments.of(new String[]{"2","1","6"}, Map.of("스트라이크", 1)),
                Arguments.of(new String[]{"1","2","3"}, new HashMap<String, Integer>() {{
                    put("볼", 1);
                    put("스트라이크",1);
                }})
        );
    }

    @DisplayName("낫싱, 3스트라이크 외에는 false이어야 한다.")
    @ParameterizedTest
    @MethodSource("provideCheckParam")
    void correctCheckAndPrintResultTest(String[] input, boolean expect) {
        List<String> answer = List.of("7","1","3");

        boolean result = BaseballPlayGround.correctCheckAndPrintResult(answer, input);
        assertEquals(expect, result);
    }

    static Stream<Arguments> provideCheckParam() {
        return Stream.of(
                Arguments.of(new String[]{"2","1","6"}, false),
                Arguments.of(new String[]{"2","4","6"}, false),
                Arguments.of(new String[]{"7","1","3"}, true),
                Arguments.of(new String[]{"1","4","6"}, false),
                Arguments.of(new String[]{"1","4","3"}, false)
        );
    }
}