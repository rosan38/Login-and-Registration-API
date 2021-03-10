/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.database.DBConnection;
import com.mycompany.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author rosan
 */
public class UserServiceImp implements UserService {

    String query = "";
    private ResultSet rs = null;
    private PreparedStatement pstm = null;
    private Connection con;
    private static Logger logger = LogManager.getLogger();

    @Override
    public String regUser(Users users) {
        String message = "";
        try {
            con = DBConnection.getConnection();
            query = "Insert into users(name,email,password) values(?,?,?)";
            pstm = con.prepareStatement(query);
            //pstm.setInt(1, users.getId());
            pstm.setString(1, users.getName());
            pstm.setString(2, users.getEmail());
            pstm.setString(3, users.getPassword());
            int status = pstm.executeUpdate();
            if (status == 1) {
                message = "User added sucessfully!";
            } else {
                message = "Sorry could not add User! Try again!";
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return message;
    }

    @Override
    public String login(Users users) {
        String message = "";
        boolean isUserAvailable = false;
        try {
            con = DBConnection.getConnection();
            query = "select * from users where email = ? and password =?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, users.getEmail());
            pstm.setString(2, users.getPassword());
            rs = pstm.executeQuery();
            while (rs.next()) {
                users.setId(rs.getInt("id"));
                isUserAvailable = true;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        if (isUserAvailable == true) {
            message = "Login sucessfull !!!";
        } else {
            message = "Wrong Email or Password !!!";
        }
        return message;
    }

}
