/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;
/**
 *
 * @author ehartml624
 */
import java.util.ArrayList;
public class Order {
    private ArrayList<Item> orderItems;
    
    public Order () {
        orderItems = new ArrayList<Item>();
        
        // set up variables here for phase 2 to reference for adding items
        
    }
    
    public void addPork () {
        orderItems.add(new Item("Oinker", 6.5, ".5lbs meat on bun"));
    }
    
    public void addChicken () {
        orderItems.add(new Item("Bok bok", 6.5, ".5lbs meat on bun"));
    }
    
    public void addChoppedBrisket () {
        orderItems.add(new Item("Chopped Moo Moo", 7.5, ".5lbs meat on bun"));
    }
    
    public void addSlicedBrisket () {
        orderItems.add(new Item("Sliced Moo Moo", 7.5, ".5lbs meat on bun"));
    }
    
    public void addSpecial () {
        orderItems.add(new Item("special", 8.5, "none"));
    }
    
    public void addPotatoSalad () {
        orderItems.add(new Item("Tater Salad", 2.0, ".5lbs in container"));
    }
    
    public void addColeSlaw () {
        orderItems.add(new Item("Slaw", 2.0, ".5lbs in container"));
    }
    
    public void addGreenBeans () {
        orderItems.add(new Item("Green Beans", 2.0, ".5lbs in container"));
    }
    
    public void addBakedBeans () {
        orderItems.add(new Item("Baked Beans", 2.0, ".5lbs in container"));
    }
    
    public void addCasserole () {
        orderItems.add(new Item("Tater role", 2.0, ".5lbs in container"));
    }
    
    public void deleteItem(int n) {
        orderItems.remove(n);
    }
    
    public void clearOrder(){
        orderItems.clear();
    }
    
    public double getTotal() {
        double subtotal = 0.0;
        for (int i = 0; i < orderItems.size(); i++ ) {
            subtotal += orderItems.get(i).getPrice();
        } 
        return subtotal;
    }
    
    public String orderPrint () {
        String order = "";
        for (int i = 0; i < orderItems.size(); i++ ) {
            order += i+1 + " " + orderItems.get(i).toString();
        }
        return order;
        
    }
    
    
}
