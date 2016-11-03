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
import java.util.Scanner;

public class PointOfSale {
    static Order order = new Order();
    static Scanner input = new Scanner(System.in);
    static TransactionController transControl = new TransactionController();
    
    public static void printOrder () {
        System.out.println("\n******* Current Order *******\n");
        System.out.println(order.orderPrint());
        System.out.printf("Subtotal: $%6.2f\n", order.getTotal());
        System.out.printf("Tax:      $%6.2f\n", order.getTotal() * .07);
        System.out.printf("Total:    $%6.2f\n", order.getTotal() * 1.07);
    }
    
    public static void adminMenu () {
        
    }
    
    // method to print out menu
    public static void printMenu() {
        System.out.println("\n0. Oinker");
        System.out.println("1. Bok Bok");
        System.out.println("2. Chopped Moo Moo");
        System.out.println("3. Sliced Moo Moo");
        System.out.println("4. Special");
        System.out.println("5. Tater Salad");
        System.out.println("6. Slaw");
        System.out.println("7. Green Beans");
        System.out.println("8. Baked Beans");
        System.out.println("9. Tater Role");
    }
    
    // method to add to order
    public static void addToOrder (String o) {
        for (int i = 0; i < o.length(); i++) {
            switch (o.charAt(i)) {
                case '0':
                    order.addPork();
                    break;
                case '1':
                    order.addChicken();
                    break;
                case '2':
                    order.addChoppedBrisket();
                    break;
                case '3':
                    order.addSlicedBrisket();
                    break;
                case '4':
                    order.addSpecial();
                    break;
                case '5':
                    order.addPotatoSalad();
                    break;
                case '6':
                    order.addColeSlaw();
                    break;
                case '7':
                    order.addGreenBeans();
                    break;
                case '8':
                    order.addBakedBeans();
                    break;
                case '9':
                    order.addCasserole();
                    break;
            }
        }
    }

    
    public static void cashPayment() {
        double cash = 0;
        do {
            System.out.print("\nEnter cash paid: ");
            cash = input.nextDouble();
            
            if (cash < order.getTotal()*1.07) {
                System.out.print("Not enough cash.");
            }
        }
        while (cash < order.getTotal()*1.07);
        transControl.addTransaction(0000, "CASH", order.getTotal(), 0);
        System.out.printf("Change:   $%6.2f\n", cash -order.getTotal() * 1.07);
    }
    
    public static void creditPayment() {
        int ref;
        System.out.print("\nPlease enter reference number: ");
        ref = input.nextInt();
        transControl.addTransaction(0000, "CREDIT", order.getTotal(), ref);
    }
    
    public static void main (String[] args) {
        // code for current day and month
        // transControl.loadDay();
        
        String userLogin = "";
        String userPin = "";
        
        // have while loop here to check login file
        System.out.print("Enter login ID: ");
        userLogin = input.nextLine();
        
        // have loop here to continue to check for correct pin
        // after 3 tries go back to login 
        System.out.print("Enter pin: ");
        userPin = input.nextLine();
        
        int mainMenu = 0;
        do {
            System.out.println("\nHartman BBQ Sale\n");
            System.out.println("1. New Order");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            
            System.out.print("Select: ");
            mainMenu = input.nextInt();
            input.nextLine();
        
            switch (mainMenu) {
                case 1:
                    System.out.println("\n**********   New Order   **********");
                    
                    printMenu();
                    
                    System.out.print("Enter in order: ");
                    String inOrder = input.nextLine();
                    
                    addToOrder(inOrder);
                    
                    // process the order
                    int orderMenu;
                    do {
                        printOrder();

                        System.out.println("\n1. Complete Order");
                        System.out.println("2. Add Item");
                        System.out.println("3. Delete Item");
                        System.out.println("4. Clear Order");
                        System.out.print("Select: ");
                        orderMenu = input.nextInt();
                        input.nextLine();

                        switch (orderMenu) {
                            case 1:
                                System.out.println("\nPayment method");
                                System.out.println("1. Cash");
                                System.out.println("2. Credit Card");
                                System.out.print("Select: ");
                                int payMethod = input.nextInt();

                                switch (payMethod) {
                                    case 1:
                                        cashPayment();
                                        break;
                                    case 2:
                                        creditPayment();
                                        break;
                                }

                                order.clearOrder();

                                System.out.println("\n***** Order Complete *****");
                                break;
                            case 2:
                                System.out.println("Add to order:\n");
                                printMenu();
                                System.out.print("Enter in order: ");
                                inOrder = input.nextLine();
                                addToOrder(inOrder);
                                break;
                            case 3:
                                System.out.print("\nEnter in number of item to delete: ");
                                int remove = input.nextInt();
                                order.deleteItem(remove-1);
                                break;
                            case 4:
                                System.out.println("\n****** Order Cleared ******");
                                order.clearOrder();
                                break;
                        }
                    }
                    while (orderMenu == 2 || orderMenu == 3);
                      
                    break; // new order main menu break
                case 2:
                    //adminMenu();
                    break;       
            }
        }
        while (mainMenu != 3);
        
        System.out.println("\n*****Thank You*****");
           
    }
    
    
}
