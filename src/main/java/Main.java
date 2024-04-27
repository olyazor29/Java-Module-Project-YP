import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int numberOfPeople;
        while (true) {
            String numberOfPeopleInput = scanner.next();

            try {
                numberOfPeople = Integer.parseInt(numberOfPeopleInput);
            } catch (NumberFormatException e) {
                InputProcessing.wrongNumberOfPeople();
                continue;
            }

            if (numberOfPeople > 1) {
                break;
            } else {
                InputProcessing.wrongNumberOfPeople();
            }
        }

        Calculator calculator = new Calculator();

        do {
            System.out.println("Введите название товара и его стоимость в формате \"рубли.копейки\":");
            String productName = scanner.next();
            double productPrice;

            while (true) {
                String productPriceInput = scanner.next();
                try {
                    productPrice = Double.parseDouble(productPriceInput);
                } catch (NumberFormatException e) {
                    InputProcessing.wrongPrice();
                    continue;
                }
                if (productPrice > 0) {
                    break;
                } else {
                    InputProcessing.wrongPrice();
                }
            }

            calculator.addNewProduct(new Product(productName, productPrice));

            System.out.println("Товар успешно добавлен!");
            System.out.println("Если это был последний товар, введите команду \"Завершить\".\n" +
                    "Чтобы продолжить добавление товаров, введите любой символ:");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));

        calculator.printListOfAddedProducts();

        System.out.println("Общая сумма всех товаров: " +
                String.format(Locale.US, "%.2f", calculator.sumOfPrices) + " " +
                RubleFormatter.getCorrectFormOfRuble(calculator.sumOfPrices));

        double sumPerPerson = calculator.calculateSumPerPerson(numberOfPeople);
        System.out.println("Сумма, которую должен заплатить каждый человек: " +
                String.format(Locale.US, "%.2f", sumPerPerson) + " " +
                RubleFormatter.getCorrectFormOfRuble(sumPerPerson));
    }
}