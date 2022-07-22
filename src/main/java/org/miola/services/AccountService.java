package org.miola.services;

import org.miola.dao.AccountDAO;
import org.miola.models.Account;

public class AccountService {
    private static AccountDAO accountDAO = new AccountDAO();

    public static Account getAccountByClientId(int id){
        return accountDAO.getAccountByClientId(id);
    }
}
