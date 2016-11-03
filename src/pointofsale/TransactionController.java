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
public class TransactionController {
    private ArrayList<Transaction> transactions;
    
    public TransactionController () {
        transactions = new ArrayList<Transaction>();
    }
    
    // load up all transactions in list for current day
    public void loadDay (int month, int day) {
        transactions = new ArrayList<Transaction>();
    }
    
    // load up all transactions in list for current month
    public void loadMonth(int year, int month) {
        transactions = new ArrayList<Transaction>();
    }
    
    // load up all transaction in list for current year
    public void loadYear(int year) {
        transactions = new ArrayList<Transaction>();
    }
    
    public void addTransaction (int tn, String pm, double total, int cc) {
        transactions.add(new Transaction(tn, pm, total, cc));
    }
    
}
