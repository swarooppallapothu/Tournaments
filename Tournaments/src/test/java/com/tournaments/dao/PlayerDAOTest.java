package com.tournaments.dao;

import com.tournaments.entities.Player;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerDAOTest {

    public PlayerDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findAllPlayers method, of class PlayerDAO.
     */
    @Test
    public void testFindAllPlayers() {
        System.out.println("findAllPlayers");
        PlayerDAO instance = new PlayerDAO();
        List<Player> expResult = null;
        List<Player> result = instance.findAllPlayers();
        assertNotNull(result);
    }

    /**
     * Test of findPlayerByPlayerId method, of class PlayerDAO.
     */
    @Test
    public void testFindPlayerByPlayerId() {
        System.out.println("findPlayerByPlayerId");
        int playerId = 0;
        PlayerDAO instance = new PlayerDAO();
        Player expResult = null;
        Player result = instance.findPlayerByPlayerId(playerId);
        assertNull(result);
    }

}
