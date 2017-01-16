/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.PlayedMatches;
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
public class PlayedMatchesDAOTest {
    
    public PlayedMatchesDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

   /**
     * Test of findAllMatches method, of class PlayedMatchesDAO.
     */
    @Test
    public void testFindAllMatches() {
        System.out.println("findAllMatches");
        PlayedMatchesDAO instance = new PlayedMatchesDAO();
        List<PlayedMatches> expResult = null;
        List<PlayedMatches> result = instance.findAllMatches();
        assertNotNull(result);
    }

    /**
     * Test of findMatchByUserId method, of class PlayedMatchesDAO.
     */
    @Test
    public void testFindMatchByUserId() {
        System.out.println("findMatchByUserId");
        User user = new User();
        user.setUserId(0);
        PlayedMatchesDAO instance = new PlayedMatchesDAO();
        List<PlayedMatches> expResult = null;
        List<PlayedMatches> result = instance.findMatchByUserId(user);
        assertNotNull(result);
    }    
}
