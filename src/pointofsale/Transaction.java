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
public class Transaction {
    private int transNum;
    private String payMethod;
    private double total;
    private int cardRefNum;
    
    public Transaction (int transNum, String payMethod, double total, int cardRefNum) {
        this.transNum = transNum;
        this.payMethod = payMethod;
        this.total = total;
        this.cardRefNum = cardRefNum;
    }
    
    public int getTransactionNum () {
        return transNum;
    }
    
    public String getPaymentMethod () {
        return payMethod;
    }
    
    public double getTotal () {
        return total;
    }
    
    public int getCardRefNum () {
        if (cardRefNum != 0) {
            return cardRefNum;
        }
        return 0;
    }
    
    public void setTransactionNum (int transNum) {
        this.transNum = transNum;
    }
    
    public void setPaymentMethod (String payMethod) {
        this.payMethod = payMethod;
    }
    
    public void setTotal (double total) {
        this.total = total;
    }
    
    public void setCardRefNum (int cardRefNum) {
        this.cardRefNum = cardRefNum;
    }
    
}
