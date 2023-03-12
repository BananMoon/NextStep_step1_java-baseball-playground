package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls;

    public Balls(List<Integer> answers) { /* REFACTOR : 인자를 List<Ball> -> List<Integer> : 클라이언트가 더 쉽게 사용할 수 있다.*/
        this.balls = mapBall(answers);
    }

    private List<Ball> mapBall(List<Integer> answers) {
        balls = new ArrayList<>();
        for (int i=0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    // (123) 에 2,1이 들어왔음. 순회하면서 동일 숫자 발견하면 볼.
    //1,1 / 2,2/ 3,3 <- 1,1 : 스트라이크
    //1,1 / 2,2/ 3,3 <- 2,1 : 볼
    // 볼, 스트라이크 중 아무것도 조회안되면 최종 낫띵
    // 값 1개 들어왔으니까 볼/스트라이크 중 먼저 나오는게 답이겠지
    public BallStatus play(Ball ball) {
        /*for (Ball answer : balls) {
            BallStatus smallStatus = answer.play(ball);   *//* REFACTOR : 작은 문제 풀 때 생성한 Ball.play(~) 쓰도록 수정 *//*
            if (smallStatus != BallStatus.NOTHING) {
                return smallStatus;
            }
        }
        return BallStatus.NOTHING;*/

        /* TRY : 함수형 방식 (조금은 비효율적임) */
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)    /* REFACTOR : ENUM 또한 인스턴스이므로, ENUM 필드에 접근하는게 아닌 메시지를 보내보자. */
//                .filter(ballStatus -> ballStatus.isNotNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);

    }

}
