package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * with 피드백 영상 (by James)
  */
public class BaseballApplication {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        final NumberGenerator ng = new NumberGenerator();
        List<Integer> randomNumbers = ng.createRandomNumbers();
        Referee referee = new Referee();

        boolean keepGoing = true;
        while (keepGoing) {
            boolean isCorrect = referee.compareAndGetResult(randomNumbers, askNumbers());
            if (isCorrect) {
                keepGoing = isRestart();
                randomNumbers = ng.createRandomNumbers();
            }
        }
    }

    private static boolean isRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return "1".equals(new Scanner(System.in).nextLine());
    }

    public static List<Integer> askNumbers() {
        List<Integer> nums = new ArrayList<>();
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        for (String num : scanner.nextLine().split("")) {
            nums.add(Integer.valueOf(num));
        }
        if (nums.size() > 3) {
            throw new IllegalArgumentException("문제 발생 - 숫자는 3자리로 입력해야 합니다.");
        }
        return nums;
    }
}
