package study.학습테스트실습_0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        System.out.println("SetTest.setUp");
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);    /* HashSet은 중복 X */
    }

    @Test
    @DisplayName("요구사항2")
    void contains() {
        assertThat(numbers.containsAll(List.of(1,2,3))).isTrue();

        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    /* 중복 제거를 위한 ParameterizedTest 사용
       주입되는 인자 갯수만큼 해당 메서드가 실행되고, @BeforeEach, @AfterEach 또한 매번 실행된다.
       주의 - @Test 애노테이션은 지워야 한다.
    */
    @DisplayName("요구사항2 - parameterizedTest 활용")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_값이포함되면True (int num) {
        System.out.println("parameterizedTest 활용 실행");
        assertTrue(numbers.contains(num));
    }

    /**
     * 1,2,3 값은 contains 메서드 실행결과 true,
     * 4,5 값을 넣으면 false 반환
     */
    @DisplayName("요구사항3")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_값이포함되면True_값이포함안되면False (int num, boolean isContains) {
        assertEquals(numbers.contains(num), isContains);
    }
}
