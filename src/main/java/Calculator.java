import java.util.ArrayList;

public class Calculator {

    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public void addNewProduct(Product newProduct) {
        listOfProducts.add(newProduct);
    }

    public double calculateSumOfAllPrices() {
        double sum = 0;
        for (Product product : this.listOfProducts) {
            sum += product.price;
        }
        return sum;
    }

    public double calculateSumPerPerson(double sum, int numberOfPeople) {
        return sum / numberOfPeople;
    }

    public void printListOfAddedProducts() {
        System.out.println("Добавленные товары:");
        for (Product product : this.listOfProducts) {

            System.out.println(product.name + " - " + product.price + " " +
                    RubleFormatter.getCorrectFormOfRuble(product.price));
        }
    }
}
