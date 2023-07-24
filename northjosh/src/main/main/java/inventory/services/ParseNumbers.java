package inventory.services;

/**
 * Helper class to parse ints and doubles
 */
public class ParseNumbers {

    public static boolean isParsableInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }


    public static boolean isParsableDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
