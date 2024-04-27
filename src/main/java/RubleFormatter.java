import java.util.Arrays;

public class RubleFormatter {
    public static String getCorrectFormOfRuble(double number) {
        String getLastDigitBeforePoint = Arrays.stream(String.valueOf(number).
                        split("\\.")).
                        toList().
                        get(0);

        if (getLastDigitBeforePoint.length() > 1) {
            return "рублей";
        } else {

            int lastDigit = Integer.parseInt(getLastDigitBeforePoint.substring(
                    getLastDigitBeforePoint.length() - 1)
            );

            return switch (lastDigit) {
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }
    }
}
