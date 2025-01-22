import java.util.Date;
class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account() { dateCreated = new Date(); }
    public Account(int newId, double newBalance) {
        setId(newId);
        setBalance(newBalance);
        dateCreated = new Date();
    }
    
    public int getId() { return id; }
    public double getBalance() { return balance; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    
    public void setId(int newId) { id = newId; }
    public void setBalance(double newBalance) { balance = newBalance; }
    public static void setAnnualInterestRate(double newAnnualInterestRate) { 
        annualInterestRate = newAnnualInterestRate; 
    }
    
    public Date getDateCreated() { return dateCreated; }
    
    public double getMonthlyInterestRate() {return annualInterestRate/1200;}
    public double getMonthlyInterest() { return balance * getMonthlyInterestRate(); }
    
    public void withdraw(double amount) { balance -= amount;}
    public void deposit(double amount) { balance += amount;}
    
}