package org.codes.Vinis;

import org.codes.Vinis.data_base.DAO.UserDAO;
import org.codes.Vinis.user.User;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            User vini = new User(0, "Vinis", 16);
            new UserDAO().createUser(vini);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
