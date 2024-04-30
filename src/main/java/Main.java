import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        InputProcessing input = new InputProcessing();

        System.out.println("На скольких человек необходимо разделить счёт?");
        int numberOfPeople = input.getNumberOfPeople();

        Calculator calculator = new Calculator();

        while (true) {
            calculator.addNewProduct(input.getNameAndPriceOfProduct());

            System.out.println("Товар успешно добавлен!");
            System.out.println("Если это был последний товар, введите команду \"Завершить\".\n" +
                    "Чтобы продолжить добавление товаров, введите любой символ:");

            String lastProductOrNot = input.scanner.nextLine().trim();
            if (lastProductOrNot.equalsIgnoreCase("Завершить")){
                break;
            }
        }

        calculator.printListOfAddedProducts();

        double sumOfAllPrices = calculator.calculateSumOfAllPrices();
        System.out.println("Общая сумма всех товаров: " +
                String.format(Locale.US, "%.2f", sumOfAllPrices) + " " +
                RubleFormatter.getCorrectFormOfRuble(sumOfAllPrices));

        double sumPerPerson = calculator.calculateSumPerPerson(sumOfAllPrices,numberOfPeople);
        System.out.println("Сумма, которую должен заплатить каждый человек: " +
                String.format(Locale.US, "%.2f", sumPerPerson) + " " +
                RubleFormatter.getCorrectFormOfRuble(sumPerPerson));
    }
}