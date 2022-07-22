package org.miola.services;

import org.miola.dao.AccountDAO;
import org.miola.dao.AuthDAO;
import org.miola.models.Account;
import org.miola.models.Client;

public class AccountService {
    private static AccountDAO accountDAO = new AccountDAO();

    private static AuthDAO authDAO = new AuthDAO();

    public static Account getAccountByClientId(int id){
        return accountDAO.getAccountByClientId(id);
    }

    public static Client login(String email , String password){
        return authDAO.login(email,password);
    }
}
