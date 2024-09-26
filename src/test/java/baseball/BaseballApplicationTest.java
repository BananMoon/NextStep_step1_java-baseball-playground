package baseball;

import baseball.domain.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballApplicationTest {

    @DisplayName("3스트라이크 외에는 false이어야 한다. (@CsvSource 이용)")
    @ParameterizedTest
    @CsvSource({"2,1,6,false", "2,4,6,false", "7,1,3,true", "1,4,6,false", "1,4,3,false"})
    void 스트라이크3_외에_false (int input1, int input2, int input3, boolean expect) { // input이 3개로 정해져있어 가능..
        final List<Integer> answer = Arrays.asList(7, 1, 3);
        List<Integer> input = Arrays.asList(input1, input2, input3);

        Referee referee = new Referee();
        boolean result = referee.compareAndGetResult(answer, input);
        assertEquals(expect, result);
    }
}