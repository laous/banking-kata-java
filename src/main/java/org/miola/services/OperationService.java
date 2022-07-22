package org.miola.services;

import org.miola.dao.AccountDAO;
import org.miola.dao.OperationDAO;
import org.miola.models.Operation;

import java.util.LinkedList;

public class OperationService {
    private static OperationDAO operationDAO = new OperationDAO();
    private static AccountDAO accountDAO = new AccountDAO();

    public static boolean  withdraw(Operation op , float balance){
        if(op.getAmount() > balance) return false;

        float newBalance = balance - op.getAmount();

        if(operationDAO.addOperation(op) && accountDAO.updateBalance(op.getAccountId() , newBalance)){
            return true;
        }

        return false;
    }

    public static boolean  deposit(Operation op, float balance){
        if(op.getAmount() < 0) return false;

        float newBalance = balance + op.getAmount();

        if(operationDAO.addOperation(op) && accountDAO.updateBalance(op.getAccountId() , newBalance)){
            return true;
        }

        return false;
    }

    public static LinkedList<Operation> getAllOperations(){
        return operationDAO.getAllOperations();
    }
}
