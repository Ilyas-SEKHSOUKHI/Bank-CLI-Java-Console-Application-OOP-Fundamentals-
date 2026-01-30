package dao;

import java.util.List;

import model.Account;

/*
AccountDao.java (interface)
C’est le contrat : “quelles opérations BD on sait faire”.
👉 Tu y mets seulement les méthodes (pas de SQL), par exemple :
saveAccount(...) → enregistrer un compte (table ACCOUNT)
saveSavingAccount(...) → infos épargne (table SAVING_ACCOUNT)
saveCurrentAccount(...) → infos courant (table CURRENT_ACCOUNT)
findAccountById(id) → récupérer un compte complet par id
findAllAccounts() → récupérer tous les comptes
updateBalance(id, newBalance) → modifier le solde
deleteAccount(id) (optionnel)
*/
interface AccountDao {
    public void saveAccount(Account account);
    public void saveSavingAccount(int accountId,double interestRate);
    public void saveCurrentAccount(int accountId,double overdraftLimit);
    public Account findAccountById(int accountId);
    public List<Account> findAllAccounts();
    public void updateBalance(int accountId,double newBalance);
    public void deleteAccount(int accountId);
}
