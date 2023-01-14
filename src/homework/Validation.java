package homework;

public class Validation {
    public static String validateString(String string, String defaultValue) {
        if (string == null || string.isBlank() || string.isEmpty()) {
            return defaultValue;
        } else {
            return string;
        }
    }

    public static Boolean validateBoolean(Boolean booleanValue) {
        if (booleanValue != null) {
            return booleanValue;
        } else {
            throw new IllegalArgumentException("Введено неправильное значение.");
        }
    }
}
