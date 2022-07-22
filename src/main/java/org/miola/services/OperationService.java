package org.miola.services;

import org.miola.dao.OperationDAO;
import org.miola.models.Operation;

import java.util.LinkedList;

public class OperationService {
    private static OperationDAO operationDAO = new OperationDAO();

    public static boolean  withdraw(Operation op , float balance){
        if(op.getAmount() > balance) return false;

        return operationDAO.addOperation(op);
    }

    public static boolean  deposit(Operation op){
        if(op.getAmount() < 0) return false;

        return operationDAO.addOperation(op);
    }

    public LinkedList<Operation> getAllOperations(){
        return operationDAO.getAllOperations();
    }
}
