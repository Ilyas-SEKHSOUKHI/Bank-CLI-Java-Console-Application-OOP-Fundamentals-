package model;

/*
## 3) Modèle POO : Account (abstraite)

### Champs à mettre dans `Account`

* `id` (String ou int)
* `ownerName` (String)
* `balance` (double)

### Méthodes dans `Account`

* `deposit(double amount)`
* `withdraw(double amount)` (peut être abstraite si tu veux forcer les règles par type)
* `toString()` (affichage propre)

💡 **Révision** :

* `private` champs + `public` getters/setters (encapsulation)
* `protected` si tu veux accessible aux classes filles.

## 4) Héritage : SavingsAccount / CurrentAccount

### `SavingsAccount extends Account`

* ajoute `interestRate`
* ajoute méthode `applyInterest()`

### `CurrentAccount extends Account`

* ajoute `overdraftLimit` (découvert autorisé)
* redéfinit `withdraw()` pour autoriser le découvert

💡 **Révision** :

* `@Override`
* `super(...)` dans le constructeur
* différence entre **polymorphisme** : `Account a = new SavingsAccount(...)`

---
 */
public class SavingsAccount extends Account {
 
    private double interestRate;

    public SavingsAccount () {
        super();
        this.interestRate = 0.0;
    }

    public SavingsAccount (double interestRate , int id , String ownerName , double balance) {
        super(id , ownerName , balance );
        this.interestRate = interestRate;
    }

    public SavingsAccount (SavingsAccount otherSavingsAccount) {
        super(otherSavingsAccount.getId(), otherSavingsAccount.getOwnerName(), otherSavingsAccount.getBalance());
        this.interestRate = otherSavingsAccount.interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        if ( interestRate < 10 ) 
            System.out.println("le client n'est pas interreser");
        else 
            System.out.println("le client est interreser");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("=====deposer====");
        if ( amount > 0) {
        double somme = getBalance() + amount ;
        }
        else 
            System.out.println("Veuillez enter une amonte > 0");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("=====retirer====");
        if ( amount > 0  && amount <= getBalance() ) {
        double somme = getBalance() - amount ;
        }
        else 
            System.out.println("Votre solde est " + getBalance() + " enter une amonte definie ");
    }
}
    
    

