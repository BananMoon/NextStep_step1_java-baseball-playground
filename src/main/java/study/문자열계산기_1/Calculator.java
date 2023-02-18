package study.문자열계산기_1;

import java.util.Scanner;

/**
 * - 일반 사칙연산 메서드
 * - 1. 문자열 계산기
 */
public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply (int a, int b) {
        return a * b;
    }
    public static int divide (int a, int b) {
        if (a == 0) {
            System.out.println("분자는 0이 될 수 없습니다.");
            return -1;
        }
        return a / b;
    }

    /**
    1. 문자열 계산기
     */
    public static int calculateFromString () {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();  // "2 + 3 * 4 / 2"
        String[] splittedCalculate = input.split(" ");
        int result = Integer.valueOf(splittedCalculate[0]);
        // 짝수는 숫자, 홀수는 문자일테니.
        for (int i=1; i < splittedCalculate.length; i+=2) {
            result = calculate(result, splittedCalculate[i], Integer.valueOf(splittedCalculate[i + 1]));   // 현재 값과 사칙연산 문자 전달
        }
        return result;
    }

    private static int calculate(int a, String calculator, int b) {
        switch (calculator) {
            case "+" : return add(a, b);
            case "-" : return subtract(a, b);
            case "*" : return multiply(a, b);
            default:   return divide(a, b);
        }
    }

    public static void main(String[] args) {
        int v = calculateFromString();          // 2 + 3 * 4 / 2 = 10
        System.out.print("결과가 10이냐? : ");
        System.out.println(v == 10);
    }
}
