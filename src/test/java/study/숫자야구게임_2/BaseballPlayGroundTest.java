package study.숫자야구게임_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

// 모든 로직에 단위테스트 구현
class BaseballPlayGroundTest {

    @Test
    @DisplayName("정답은 3자리여야 한다.")
    void setNumberTest() {
        List<String> answer = BaseballPlayGround.setNumber();
        assertEquals(answer.size(), 3);
    }

    @Test
    @DisplayName("같은 수&같은 위치는 스트라이크, 같은 수가 있기만 하면 볼, 전혀 없으면 낫싱")
    void getCompareResultTest() {
        List<String> answer = List.of("7","1","3");
        String[] input1 = new String[]{"2","1","6"};    // 1스트라이크

        Map<String, Integer> expected = new HashMap<>();
        expected.put("스트라이크", 1);
        // compareResult static 해쉬맵은 테스트메서드에서 어떻게 사용하지?
        Map<String, Integer> result = BaseballPlayGround.getCompareResult(answer, input1);
        assertAll(
                () -> assertEquals(expected.size(), result.size()),
                () -> assertEquals(expected.get("스트라이크"), result.get("스트라이크"))
        );
        assertNull(result.get("볼"));


        String[] input2 = new String[]{"1","2","3"};    // 1볼 1스트라이크
        Map<String, Integer> expected2 = new HashMap<>();
        expected2.put("스트라이크", 1);
        expected2.put("볼", 1);
        Map<String, Integer> result2 = BaseballPlayGround.getCompareResult(answer, input2);
        assertAll(
                () -> assertEquals(expected2.size(), result2.size()),
                () -> assertEquals(expected2.get("스트라이크"), result2.get("스트라이크")),
                () -> assertEquals(expected2.get("볼"), result2.get("볼"))
        );
    }
    // 작성 예정
    // TODO System.in을 어떻게 할지?
    // TODO 따로 메서드로 빼서 System.in을 세팅하면 가능한 듯함.
    @Test
    @DisplayName("정답을 맞췄을 때 끝나야 한다.")
    void guessAnswerUntilCorrectTest() {
        List<String> computer = List.of("7","1","3");
        BaseballPlayGround.guessAnswerUntilCorrect(computer);
    }

    @Test
    @DisplayName("낫싱, 3스트라이크 외에는 false이어야 한다.")
    void correctCheckAndPrintResultTest() {
        List<String> answer = List.of("7","1","3");
        String[] oneStrikeInput = new String[]{"2","1","6"};    // 1스트라이크
        String[] notSynchInput = new String[]{"2","4","6"};    // 낫싱
        String[] strikeInput = new String[]{"7","1","3"};    // 스트라이크
        String[] ballInput = new String[]{"1","4","6"};    // 볼
        String[] ballAndStrikeInput = new String[]{"1","4","3"};    // 1볼 1스트라이크

        boolean isCorrect = BaseballPlayGround.correctCheckAndPrintResult(answer, oneStrikeInput);
        boolean isCorrect2 = BaseballPlayGround.correctCheckAndPrintResult(answer, notSynchInput);
        boolean isCorrect3 = BaseballPlayGround.correctCheckAndPrintResult(answer, strikeInput);
        boolean isCorrect4 = BaseballPlayGround.correctCheckAndPrintResult(answer, ballInput);
        boolean isCorrect5 = BaseballPlayGround.correctCheckAndPrintResult(answer, ballAndStrikeInput);

        assertAll(
                () -> assertFalse(isCorrect),
                () -> assertFalse(isCorrect2),
                () -> assertFalse(isCorrect4),
                () -> assertFalse(isCorrect5)
        );
        assertTrue(isCorrect3);
    }
}