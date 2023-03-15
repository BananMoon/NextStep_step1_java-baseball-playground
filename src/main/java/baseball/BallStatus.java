package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE
    ;

    public boolean isNotNothing() {
        return this != BallStatus.NOTHING;
    }

    public boolean isBall() {
        return this == BallStatus.BALL;
    }

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

}
