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

        public Map <String, Account> compteName ;

        public BankServiceImpl() {
            this.compteName =  new HashMap<>();
        }

        public BankServiceImpl(Map <String, Account> compteName) {
            this.compteName =  new HashMap<>(compteName);
        }

        public BankServiceImpl(BankServiceImpl other) {
            this.compteName =  new HashMap<>(other.compteName);
        }
        


}
