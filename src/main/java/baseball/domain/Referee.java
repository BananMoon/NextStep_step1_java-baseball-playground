package baseball.domain;

import baseball.BallStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public boolean compareAndGetResult(List<Integer> computer, List<Integer> input) {
        // 컴퓨터의 수와 비교하여 결과 출력
        Map<String, Integer> compareResult = getResultMap(computer, input);
        String result = "";

        if (compareResult.size() == 0) {
            System.out.println(BallStatus.NOTHING.getKor());
            return false;
        }
        if (compareResult.containsKey(BallStatus.STRIKE.getKor()) && compareResult.get(BallStatus.STRIKE.getKor()) == 3) {
            System.out.println(3 + BallStatus.STRIKE.getKor());
            System.out.println("야구공 숫자 정답: "+ computer.toString());
            return true;
        }
        for (String key : compareResult.keySet()) {
            result += compareResult.get(key);
            result += (key + " ");
        }
        System.out.println(result);
        return false;
    }

    public Map<String, Integer> getResultMap(List<Integer> computer, List<Integer> input) {
        // 볼과 스트라이크 갯수를 구한다. (Map 자료구조 이용)
        Map<String, Integer> gameResultMap = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            // 스트라이크
            if (computer.get(i).equals(input.get(i))) {
                gameResultMap.put(BallStatus.STRIKE.getKor(),
                        gameResultMap.getOrDefault(BallStatus.STRIKE.getKor(), 0) + 1);
                continue;
            }
            // 볼
            if (computer.contains(input.get(i))) {
                gameResultMap.put(BallStatus.BALL.getKor(),
                        gameResultMap.getOrDefault(BallStatus.BALL.getKor(), 0) + 1);
            }
        }
        return gameResultMap;
    }
}
