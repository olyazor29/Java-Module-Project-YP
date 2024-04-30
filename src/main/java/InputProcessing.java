import java.util.Locale;
import java.util.Scanner;

public class InputProcessing {
    Scanner scanner = new Scanner(System.in);

    public int getNumberOfPeople() {
        int numberOfPeople;

        while (true) {
            String numberOfPeopleInput = scanner.nextLine();

            if (numberOfPeopleInput.isEmpty()) {
                this.emptyLineMessage();
                continue;
            }

            try {
                numberOfPeople = Integer.parseInt(numberOfPeopleInput.trim());
            } catch (NumberFormatException e) {
                this.wrongNumberOfPeopleMessage();
                continue;
            }

            if (numberOfPeople > 1) {
                break;
            } else {
                this.wrongNumberOfPeopleMessage();
            }
        }
        return numberOfPeople;
    }

    public Product getNameAndPriceOfProduct() {
        scanner.useLocale(Locale.US);

        String productName;
        double productPrice;

        while (true) {
            productName = scanner.next().trim();

            String productPriceInput = scanner.nextLine().trim();

            try {
                productPrice = Double.parseDouble(productPriceInput);
            } catch (NumberFormatException e) {
                this.wrongProductInfoMessage();
                continue;
            }
            if (productPrice > 0) {
                break;
            } else {
                this.wrongProductInfoMessage();
            }
        }
        return new Product(productName, productPrice);
    }

    public void wrongNumberOfPeopleMessage() {
        System.out.println("""
                    Введено некорректное значение.
                    Количество гостей должно быть больше 1.
                    Введите новое значение:""");
    }

    public void emptyLineMessage() {
        System.out.println("""
                Получена пустая строка!
                Введите требуемые значения ещё раз:
                """);
    }

    public void wrongProductInfoMessage() {
        System.out.println("""
                Неверное значение!
                Необходимо ввести название и стоимость товара.
                Стоимость товара должна быть представлена в виде положительного числа.
                Введите данные заново:""");
    }
}
