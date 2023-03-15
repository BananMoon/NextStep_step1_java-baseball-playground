package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    PlayResult() {
        strike = 0;
        ball = 0;
    }
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isBall()) {
            ball++;
        }
        if (ballStatus.isStrike()) {
            strike++;
        }
    }

    public boolean gameEnd() {
        return strike == 3;
    }
}
