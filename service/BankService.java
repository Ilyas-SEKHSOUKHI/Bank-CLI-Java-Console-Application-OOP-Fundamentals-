package service;
/*
Crée une interface `BankService` qui définit les opérations :

* `createSavingsAccount(...)`
* `createCurrentAccount(...)`
* `deposit(String id, double amount)`
* `withdraw(String id, double amount)`
* `printAccount(String id)`
* `printAllAccounts()`
*/
interface BankService {
    public void createSavingsAccount();
    public void createCurrentAccount();
    public void deposit(String id,double amount);
    public void withdraw(String id,double amonte);
    public void printAccount(String id);
    public void printAllAccounts();
}
