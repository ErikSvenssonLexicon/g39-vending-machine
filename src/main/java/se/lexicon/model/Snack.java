package se.lexicon.model;

public class Snack implements Product{

    private int id;
    private double price;
    private String snack;

    public Snack(int id, double price, String snack) {
        this.id = id;
        this.price = price;
        this.snack = snack;
    }

    @Override
    public String examine() {
        return "{ id: " + id + ", snack: " + snack + " }";
    }

    @Override
    public String use() {
        return "You eat some " + snack;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return snack;
    }

    @Override
    public void setProductName(String productName) {
        this.snack = productName;

    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
