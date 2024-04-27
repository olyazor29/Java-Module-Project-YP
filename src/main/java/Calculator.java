import java.util.ArrayList;

public class Calculator {
    double sumOfPrices = 0;
    ArrayList<Product> listOfProducts = new ArrayList<>();


    public void addNewProduct(Product newProduct) {
        this.sumOfPrices += newProduct.price;
        listOfProducts.add(newProduct);
    }

    public double calculateSumPerPerson(int numberOfPeople) {
        return this.sumOfPrices / numberOfPeople;
    }

    public void printListOfAddedProducts() {
        System.out.println("Добавленные товары:");
        for (Product product : this.listOfProducts) {

            System.out.println(product.name + " - " + product.price + " " +
                    RubleFormatter.getCorrectFormOfRuble(product.price));
        }
    }
}
