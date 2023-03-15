package baseball;

public class ValidationUtils {
    private static final int VALID_MIN = 0;
    private static final int VALID_MAX = 9;
    public static boolean isValidNo(int inputNo) {
        return inputNo > VALID_MIN && inputNo <= VALID_MAX;
    }
}
