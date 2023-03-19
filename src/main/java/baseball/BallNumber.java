package baseball;

public class BallNumber {
    private static final int VALID_MIN = 1;
    private static final int VALID_MAX = 9;

    private final int no;

    public BallNumber(int no) {
        /* 유효성 체크 */
        if (no < VALID_MIN || no > VALID_MAX) {
            throw new IllegalArgumentException("볼 숫자는 1~9 사이의 숫자이어야 한다.");
        }
        this.no = no;
    }
    public int getNo() {
        return no;
    }
}
