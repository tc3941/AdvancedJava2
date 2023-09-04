package genericsLambdas;

import java.util.List;
import java.util.stream.Stream;

public class Product {
    //define the instance variables for 'name' and 'price'
String name;
double price;

    //define a public constructor for Product that takes a name and price as input and sets the instance variables accordingly


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    private double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        //Make an Inventory object that holds Products
        Inventory<Product> myInventory  = new Inventory<>();
        //Add as many products as you want to your Inventory Object using the addItem() method you defined
        myInventory.addItem(new Product("Hank Hill", 420));
        myInventory.addItem(new Product("Dota 2", 322));
        myInventory.addItem(new Product("CSGO", 1));
        myInventory.addItem(new Product("Valorant", 2));

        //Your task is to calculate the total price of all products in an Inventory object called myInventory. Follow these steps:
        //1. Call the getItems method on your inventory object to retrieve the list of all products.
        List<Product> productList = myInventory.getList();
        //2. Convert this list into a stream by calling the stream method.
        Stream<Double> priceStream = productList.stream().map(product -> product.getPrice());
        //doing map to double causes exceptions so I just did map

        //3. Apply the mapToDouble operation to this stream. The operation should be applied to each Product object
        //	 	in the stream, converting it into its price. Use the lambda expression product -> product.price to
        //		perform this conversion. This expression means "for each product, return its price".
        //4. Apply the sum operation to the stream to get the total price of all products.

        //5. Store this total price in a double variable called priceTotal.
        double priceTotal = priceStream.mapToDouble(Double::doubleValue).sum();
        //6. Print out priceTotal to the console to make sure you are properly summing your Products!
        System.out.println(priceTotal);




        //Helpful documentation:
        //https://www.baeldung.com/java-stream-sum#using-streamsum-with-objects

    }


}