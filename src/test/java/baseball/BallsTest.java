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
    void play_nothing() {
        // 3자리 vs 3자리 테스트
        // PlayResult : 스트라이크/볼 여부와 횟수 값을 갖고 있는 객체
        PlayResult nothingResult = answer.play(List.of(4, 5, 6));  // 낫띵
        assertThat(nothingResult.getStrike()).isEqualTo(0);
        assertThat(nothingResult.getBall()).isEqualTo(0);
    }
    @Test
    void play_1strike_1ball() {
        PlayResult ballResult = answer.play(List.of(4, 1, 3)); // 1스트라이크 1볼
        assertThat(ballResult.getStrike()).isEqualTo(1);
        assertThat(ballResult.getBall()).isEqualTo(1);
    }
    @Test
    void play_3strike() {
        PlayResult ballResult = answer.play(List.of(1, 2, 3)); // 3스트라이크
        assertThat(ballResult.getStrike()).isEqualTo(3);
        assertThat(ballResult.getBall()).isEqualTo(0);
        // 3스트라이크 시, 게임이 끝나야 하므로 추가 테스트
        assertThat(ballResult.gameEnd()).isEqualTo(true);
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
