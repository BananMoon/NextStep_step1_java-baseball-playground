package study.숫자야구게임_2;

import java.util.*;

public class BaseballPlayGround {
    public static final Scanner scanner = new Scanner(System.in);
    public static Map<String, Integer> compareResult = null;
    public static void playGame() {
        boolean keepGoing = true;
        while (keepGoing) {
            // 1. 임의의 컴퓨터 수 지정 (random)
            List<String> answer = setNumber();

            // 2. 사용자 입력 및 맞추기
            guessAnswerUntilCorrect(answer);

            // 3. 다시 시작할 것인가?
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if ("2".equals(scanner.nextLine())) {
                keepGoing = false;
            }
        }
    }

    public static void guessAnswerUntilCorrect (List<String> answer) {
        boolean isCorrect = false;
        while(!isCorrect) {
            System.out.print("숫자를 입력해 주세요 : ");
            String[] input = scanner.nextLine().split("");

            isCorrect = correctCheckAndPrintResult(answer, input);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        compareResult = null;
    }

    public static boolean correctCheckAndPrintResult(List<String> answer, String[] input) {
        // 컴퓨터의 수와 비교하여 결과 출력
        compareResult = getCompareResult(answer, input);
        String result = "";

        if (compareResult.size() == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (compareResult.containsKey("스트라이크") && compareResult.get("스트라이크")  == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        for (String key : compareResult.keySet()) {
            result += compareResult.get(key);
            result += (key + " ");
        }
        System.out.println(result);
        return false;
    }

    //랜덤으로 세자리 숫자 세팅
    //세 숫자 모두 달라야 한다.
    public static List<String> setNumber() {
        Random random = new Random();
        Set<String> strs = new HashSet<>();
        while (strs.size() < 3) {
            int randomInt = random.nextInt(10);
            strs.add(String.valueOf(randomInt));
        }
        return new ArrayList<>(strs);
    }

    // 같은 수가 같은 위치에 있으면 스트라이크 추가
    // 같은 수가 있기만 하면 볼
    // 같은 수가 전혀 없으면 낫싱
    public static Map<String, Integer> getCompareResult(List<String> answer, String[] input) {
        Map<String, Integer> gameResultMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            // 스트라이크
            if (answer.get(i) == input[i]) {
                gameResultMap.put("스트라이크",
                        gameResultMap.getOrDefault("스트라이크", 0)+1);
                continue;
            }
            // 볼
            if (answer.contains(input[i])) {
                gameResultMap.put("볼",
                        gameResultMap.getOrDefault("볼", 0)+1);
            }
        }
        return gameResultMap;
    }
}
