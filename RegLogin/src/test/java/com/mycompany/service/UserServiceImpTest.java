/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rosan
 */
public class UserServiceImpTest {

    public UserServiceImpTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of regUser method, of class UserServiceImp.
     */
    @Test
    public void testRegUser() {
        System.out.println("regUser");
        Users users = new Users();
        users.setName("rosan");
        users.setEmail("rosan@gmail.com");
        users.setPassword("123");
        UserServiceImp instance = new UserServiceImp();
        String expResult = "User added sucessfully!";
        String result = instance.regUser(users);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        ///fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserServiceImp.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Users users = new Users();
        users.setEmail("rosan@gmail.com");
        users.setPassword("rosan123");
        UserServiceImp instance = new UserServiceImp();
        String expResult = "Login sucessfull !!!";
        String result = instance.login(users);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserServiceImp.
     */
    @Test
    public void testLogin1() {
        System.out.println("login");
        Users users = new Users();
        users.setEmail("rosan@gmail.com");
        users.setPassword("rosan123456");
        UserServiceImp instance = new UserServiceImp();
        String expResult = "Wrong Email or Password !!!";
        String result = instance.login(users);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
