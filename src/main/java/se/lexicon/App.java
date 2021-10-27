package se.lexicon;

import se.lexicon.model.Beverage;
import se.lexicon.model.Fruit;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;
import se.lexicon.service.VendingMachine;
import se.lexicon.service.VendingMachineManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Product[] products = {
                new Beverage(1, "Beer", true, 30, 75),
                new Beverage(2, "Orange Juice", false, 25, 20),
                new Fruit(3, "Orange", "Orange", 10),
                new Fruit(4, "Banana", "Yellow", 11),
                new Snack(5, 20, "Snickers"),
                new Snack(6, 1000, "Exclusive snack")
        };
        VendingMachine vendingMachine = new VendingMachineManager(products);

        for(String string : vendingMachine.getProducts()){
            System.out.println(string);
            System.out.println("-----");
        }

        vendingMachine.addCurrency(50);
        Product banana = vendingMachine.request(4);
        System.out.println(banana.use());
        System.out.println(vendingMachine.getBalance());


    }
}
