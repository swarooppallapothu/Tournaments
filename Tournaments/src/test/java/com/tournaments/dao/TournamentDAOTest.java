/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.Tournament;
import com.tournaments.entities.User;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author srinubabu
 */
public class TournamentDAOTest {
    
   public TournamentDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of findAll method, of class TournamentDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TournamentDAO instance = new TournamentDAO();
        List expResult = null;
        List result = instance.findAll();
        assertNotNull(result);
    }

    /**
     * Test of findTournamentsByUserId method, of class TournamentDAO.
     */
    @Test
    public void testFindTournamentsByUserId() {
        System.out.println("findTournamentsByUserId");
        User user = new User();
        user.setUserId(0);
        TournamentDAO instance = new TournamentDAO();
        List expResult = null;
        List result = instance.findTournamentsByUserId(user);
        assertNotNull(result);
    }  
}
