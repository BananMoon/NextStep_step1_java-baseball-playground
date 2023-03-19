package baseball.domain;

import java.util.List;

public class Referee {
    public String compareAndGetResult(List<Integer> computer, List<Integer> input) {
        return "3 스트라이크";
    }
    // 특정 위치에 특정 숫자가 있는가?
    public boolean isSamePlace(int positionNum, int number) {
        return true;
    }

    public int countCorrect(List<Integer> computer, List<Integer> input) {
        return 0;
    }
}
