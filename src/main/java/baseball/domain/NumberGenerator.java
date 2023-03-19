package baseball.domain;

import java.util.*;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int randomInt = new Random().nextInt(9) + 1;  // 0부터 n-1까지 -> 1부터 9까지여야하므로 n=9로 지정
            numbers.add(randomInt);
        }
        return new ArrayList<>(numbers);
    }
}
