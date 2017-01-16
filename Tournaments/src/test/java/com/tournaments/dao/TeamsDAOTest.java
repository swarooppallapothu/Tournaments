package com.tournaments.dao;

import com.tournaments.entities.Team;
import com.tournaments.entities.User;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeamsDAOTest{
    
    public TeamsDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

   /**
     * Test of findAllTeams method, of class TeamsDAO.
     */
    @Test
    public void testFindAllTeams() {
        System.out.println("findAllTeams");
        TeamsDAO instance = new TeamsDAO();
        List expResult = null;
        List result = instance.findAllTeams();
        assertNotNull(result);
    }

    /**
     * Test of findTeamsByUserId method, of class TeamsDAO.
     */
    @Test
    public void testFindTeamsByUserId() {
        System.out.println("findTeamsByUserId");
        User user = new User();
        user.setUserId(0);
        TeamsDAO instance = new TeamsDAO();
        List expResult = null;
        List result = instance.findTeamsByUserId(user);
        assertNotNull(result);
    }

    /**
     * Test of findTeamsByUserName method, of class TeamsDAO.
     */
    @Test
    public void testFindTeamsByUserName() {
        System.out.println("findTeamsByUserName");
        User user = new User();
        user.setUserName("admin");
        TeamsDAO instance = new TeamsDAO();
        List expResult = null;
        List result = instance.findTeamsByUserName(user);
        assertNotNull(result);
    }

    /**
     * Test of getTeam method, of class TeamsDAO.
     */
    @Test
    public void testGetTeam() {
        System.out.println("getTeam");
        int teamId = 0;
        TeamsDAO instance = new TeamsDAO();
        Team expResult = null;
        Team result = instance.getTeam(teamId);
        assertEquals(result, expResult);
    }
    
}
