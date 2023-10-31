public class Validator {

    private Validator() {
    }

    public static void validateString(String str) {
        validateString(str, "Name cannot be empty");
    }

    public static void validateString(String str, String message) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateValueNonNegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

}
