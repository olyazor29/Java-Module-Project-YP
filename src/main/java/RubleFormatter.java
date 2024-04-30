
public class RubleFormatter {
    public static String getCorrectFormOfRuble(double number) {

        int lastTwoDigits = (int) Math.floor(number % 100);

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "рублей";
        } else {
            int lastDigit = lastTwoDigits % 10;
            return switch (lastDigit) {
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }
    }
}
