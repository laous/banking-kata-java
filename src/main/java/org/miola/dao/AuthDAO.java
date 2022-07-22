package org.miola.dao;

import org.miola.models.Client;

import java.sql.*;

public class AuthDAO {
    private Connection con;

    public AuthDAO()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking-kata-java","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Client login(String email, String password){
        String query = "SELECT * FROM client WHERE email like'"+email+"' AND password like '"+password+"'";
        Statement stmt ;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                return new Client(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Client not  found");
        return null;
    }

}
