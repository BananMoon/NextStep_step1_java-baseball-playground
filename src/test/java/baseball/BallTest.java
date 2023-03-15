package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball answer;

    @BeforeEach
    void setUp() {
        answer = new Ball(1, 4);
    }
    @Test
    void strike() {
        assertThat(answer.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    void ball() {
        assertThat(answer.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(answer.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }
}
