package se.lexicon.service;

import se.lexicon.model.Product;

public class VendingMachineManager implements VendingMachine{

    public static final int[] VALID_DENOMINATIONS = {1,2,5,10,20,50,100,200,500,1000};
    private final Product[] products;
    public int depositPool;

    public VendingMachineManager(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        for(int validDenomination : VALID_DENOMINATIONS){
            if(validDenomination == amount){
                depositPool += amount;
            }
        }
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for(Product product : products){
            if(product.getId() == id){
                if(product.getPrice() <= depositPool){
                    depositPool = (int) (depositPool - product.getPrice());
                    return product;
                }else{
                    throw new RuntimeException("Product " + product.getProductName() + " is too expensive");
                }
            }
        }
        throw new RuntimeException("Could not find Product with id " + id);
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    @Override
    public String getDescription(int id) {
        String notFound = "Could not find product with id " + id;
        for(Product product : products){
            if(product.getId() == id){
                return product.examine().concat(" price: " + product.getPrice());
            }
        }
        return notFound;
    }

    @Override
    public String[] getProducts() {
        String[] productsAsString = new String[products.length];
        for(int i=0; i<products.length; i++){
            productsAsString[i] = products[i].examine().concat(" price: " + products[i].getPrice());
        }
        return productsAsString;
    }
}
