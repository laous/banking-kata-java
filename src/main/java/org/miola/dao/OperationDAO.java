package org.miola.dao;

import org.miola.models.Operation;

import java.sql.*;
import java.util.LinkedList;

public class OperationDAO {
    private Connection con;

    public OperationDAO()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking-kata-java","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Operation> getAllOperations(){
        LinkedList<Operation> operations= new LinkedList<>();


        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from operation");


            while (rs.next()) {
                Operation operation= new Operation(rs.getInt("id"),rs.getInt("clientId"),rs.getInt("accountId"),rs.getString("type"),rs.getFloat("amount"), rs.getString("createdAt") );
                operations.add(operation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operations;
    }

    public boolean addOperation(Operation op){
        String query = "INSERT INTO operation (clientId,accountId,type,amount,createdAt) VALUES" +
                "('"+op.getClientId()+"','"+op.getAccountId()+"','"+String.valueOf(op.getType())+"','"+op.getAmount()+"','"+op.getCreatedAt()+"')";
        Statement stmt = null;
        int rs=0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs > 0;
    }
}
