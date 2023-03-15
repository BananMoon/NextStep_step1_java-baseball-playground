package baseball;

import java.util.HashMap;
import java.util.Map;

public class PlayResult {
    private final Map<BallStatus, Integer> playResult;

    PlayResult() {
        playResult = new HashMap<>();
    }
    public int getStrikeCnt() {
        return playResult.getOrDefault(BallStatus.STRIKE, 0);
    }

    public int getBallCnt() {
        return playResult.getOrDefault(BallStatus.BALL, 0);
    }

    public void report(BallStatus ballStatus) {
        Integer currCnt = playResult.getOrDefault(ballStatus, 0);
        playResult.put(ballStatus, currCnt + 1);
    }

    public boolean gameEnd() {
        return playResult.get(BallStatus.STRIKE) == 3;
    }
}
