package baseball;

public enum BallStatus {
    NOTHING("낫씽"),
    BALL("볼"),
    STRIKE("스트라이크")
    ;
    private final String kor;

    BallStatus(String kor) {
        this.kor = kor;
    }

    public String getKor() {
        return this.kor;
    }

    public boolean isNotNothing() {
        return this != BallStatus.NOTHING;
    }
}
