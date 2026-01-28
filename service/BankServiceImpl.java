package service;
import model.Account;
import java.util.Map;
import java.util.HashMap;

/*
## 5) Interface : BankService

Crée une interface `BankService` qui définit les opérations :

* `createSavingsAccount(...)`
* `createCurrentAccount(...)`
* `deposit(String id, double amount)`
* `withdraw(String id, double amount)`
* `printAccount(String id)`
* `printAllAccounts()`

Puis `BankServiceImpl implements BankService` :

* stocke les comptes dans un `Map<String, Account>` (id → account)
  (ou `ArrayList<Account>` si tu veux simple, mais `Map` est plus “bank-like”).

💡 **Révision** :

* `interface` = contrat
* `implements` = fournir le code
* `Map` + `containsKey` + `get`

*/

public class BankServiceImpl implements BankService {

        public Map <Integer, Account> compteName ;

        public BankServiceImpl() {
            this.compteName =  new HashMap<>();
        }

        public BankServiceImpl(Map <Integer, Account> compteName) {
            this.compteName =  new HashMap<>(compteName);
        }

        public BankServiceImpl(BankServiceImpl other) {
            this.compteName =  new HashMap<>(other.compteName);
        }
        
        public void createSavingsAccount() {
            
        }

        public void createCurrentAccount() {

            System.out.println("Enter your Id : ");
                int id = sc.nextInt();
                sc.nextLine();
            if( compteName.containsKey(id) ) {
                System.out.println("Id already exists");
                return;
            }
            System.out.println("Enter your Name : ");
                String name = sc.nextLine();
            System.out.println("Enter your Sold : ");
                Double sold = sc.nextDouble();
                sc.nextLine();
            System.out.println(" Enter your overdraftLimit : ");
                Boolean overCardLimit = sc.nextBoolean();
                sc.nextLine();
            Account account = new CurrentAccount(id, name, sold, overCardLimit);
            compteName.put(id, account);
            System.out.println("Your account has been created successfuly");
            
        }

        public void deposit(int id, double amount) {

        }

        public void withdraw(int id, double amount) {

        }

        public void printAccount(int id) {

        }

        public void printAllAccounts() {

        }
        

}
