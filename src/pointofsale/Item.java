/*
 * This code is private and property of Lucas Hartman.
 */
package pointofsale;
/**
 *
 * @author Lucas Hartman
 */
public class Item {
    private String name;
    private double price;
    private String description;
    
    public Item () {
        name = "";
        price = 0.0;
        description = "";
    }
    
    public Item (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice (double price){
        this.price = price;
    }
    
    public void setDescription (String description) {
        this.description = description;
    }
    
    @Override
    public String toString () {
        return String.format("%-10s $%5.2f\n", name, price);
    }
    
}
