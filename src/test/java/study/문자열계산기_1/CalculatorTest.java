package study.문자열계산기_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator cal;
    @BeforeEach
    void setUp() {
        System.out.println("study.문자열계산기_1.CalculatorTest.setUp");
        cal = new Calculator();
    }
    @AfterEach
    void tearDown() {
        System.out.println("study.문자열계산기_1.CalculatorTest.tearDown");
        cal = null;
    }

    @Test
    void addTest() {
        System.out.println("study.문자열계산기_1.CalculatorTest.addTest");
        assertEquals(3, cal.add(1, 2));
    }

    @Test
    void subtractTest() {
        System.out.println("study.문자열계산기_1.CalculatorTest.subtractTest");
        assertEquals(1, cal.subtract(2,1 ));
    }

    @Test
    void multiplyTest() {
        System.out.println("study.문자열계산기_1.CalculatorTest.multiplyTest");
        assertEquals(8, cal.multiply(2, 4));
    }

    @Test
    void divideTest() {
        System.out.println("study.문자열계산기_1.CalculatorTest.divideTest");
        assertEquals(2, cal.divide(10,5));
    }
}