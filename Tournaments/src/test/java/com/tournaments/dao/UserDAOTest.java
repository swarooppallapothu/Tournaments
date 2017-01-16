package com.tournaments.dao;

import com.tournaments.entities.User;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {

    public UserDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of registerUser method, of class UserDAO.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.registerUser(user);
        assertEquals(result, expResult);
    }

    /**
     * Test of findAll method, of class UserDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UserDAO instance = new UserDAO();
        List expResult = null;
        List result = instance.findAll();
        assertNotNull(result);
    }

    /**
     * Test of findByUsername method, of class UserDAO.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        User user = new User();
        user.setUserName("admin");
        UserDAO instance = new UserDAO();
        User result = instance.findByUsername(user);
        assertNotNull(result);
    }

}
