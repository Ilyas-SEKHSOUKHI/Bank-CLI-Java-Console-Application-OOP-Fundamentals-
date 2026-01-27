package model;
/*
### `CurrentAccount extends Account`

* ajoute `overdraftLimit` (découvert autorisé)
* redéfinit `withdraw()` pour autoriser le découvert
*/
public class CurrentAccount extends Account {
    private boolean overdraftLimit;
    public CurrentAccount(){
        super();
        this.overdraftLimit = false;
    }
    public CurrentAccount(int id,String ownerName,double balance,boolean overdraftLimit){
        super(id,ownerName,balance);
        this.overdraftLimit = overdraftLimit;
    }
    public CurrentAccount(CurrentAccount other){
        super(other);
        this.overdraftLimit = other.overdraftLimit;
    }
    public boolean getOverdraftLimit(){
        return overdraftLimit;
    }
    public void setOverdraftLimit(boolean overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void deposit(double amount){
        System.out.println("=====Deposit=====");
        if(amount<=0){
            System.out.println("Euror");
        }else{
            double Somme = getBalance() + amount;
        }
    }
    @Override
    public void withdraw(double amount){
        System.out.println("=====Withdraw=====");
        if (amount<=0 && amount>getBalance()){
            System.out.println("Euror");
        }else{
            double Soustraction = getBalance() - amount;
        }
    }
}
