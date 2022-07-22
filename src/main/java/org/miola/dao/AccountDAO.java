package org.miola.dao;

import org.miola.models.Account;

import java.sql.*;

public class AccountDAO {
    private Connection con;

    public AccountDAO()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking-kata-java","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean updateBalance(int id, float balance){
        String query = "UPDATE account SET balance = '"+balance+"' WHERE clientId LIKE "+id;

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return true;
    }

    public Account getAccountByClientId(int id){
        String query = "SELECT * FROM account WHERE clientId like '" + id +"'";
        Statement stmt ;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                System.out.println("Here");
                return new Account(rs.getInt("id"), rs.getInt("clientId"), rs.getFloat("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
