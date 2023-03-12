package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls answer;

    @BeforeEach
    void setUp() {
        List<Integer> balls = List.of(1, 2, 3);
        answer = new Balls(balls);
    }

    @Test
    void strike() {
        BallStatus result = answer.play(new Ball(1, 1));
        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus result = answer.play(new Ball(2, 1));
        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus result = answer.play(new Ball(1, 4));
        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }
}
