package dao;

import java.util.List;

import model.Account;

/*
    public void saveAccount();
    public void saveSavingAccount();
    public void saveCurrentAccount();
    public void findAccountById();
    public void findAllAccounts();
    public void updateBalance();
    public void deleteAccount();
*/
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount(Account account){

    }
    @Override
    public void saveSavingAccount(int accountId,double interestRate){

    }
    @Override
    public void saveCurrentAccount(int accountId,double overdraftLimit){

    }
    @Override
    public Account findAccountById(int accountId){
        return null;
    }
    @Override
    public List<Account> findAllAccounts(){
        return null;
    }
    @Override
    public void updateBalance(int accountId,double newBalance){

    }
    @Override
    public void deleteAccount(int accountId){

    }
}
