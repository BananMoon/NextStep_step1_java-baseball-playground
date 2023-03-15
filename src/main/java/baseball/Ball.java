package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {//1,4 - 2,4 ; ball, 1,4:2,5:
        /* REFACTOR : null 예외 처리 */
        if (Objects.isNull(ball)) {
            System.out.println("null 값입니다.");
            return null;
        }
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNo(ballNo)) {   /* REFACTOR 객체에 메시지를 보내자. */
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
