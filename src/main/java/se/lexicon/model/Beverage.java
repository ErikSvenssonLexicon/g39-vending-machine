package se.lexicon.model;

public class Beverage implements Product{

    private int id;
    private String beverageName;
    private boolean alcoholic;
    private int sugarPercentage;
    private double price;

    public Beverage(int id, String beverageName, boolean alcoholic, int sugarPercentage, double price) {
        this.id = id;
        this.beverageName = beverageName;
        this.alcoholic = alcoholic;
        this.sugarPercentage = sugarPercentage;
        this.price = price;
    }

    @Override
    public String examine() {
        return "{ id: " + id + ", beverage: " + beverageName + " with " + sugarPercentage+"% sugar }";
    }

    @Override
    public String use() {
        String description = "You drink some " + beverageName;
        description += alcoholic ? " and feel a bit tipsy" : "";
        return description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return beverageName;
    }

    @Override
    public void setProductName(String productName) {
        this.beverageName = productName;
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
