/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.Player;
import com.tournaments.entities.TeamPlayer;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author srinubabu
 */
public class PlayerDAO {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction etx = null;

    public PlayerDAO() {
        emf = Persistence.createEntityManagerFactory("JPAStrutsPU", System.getProperties());
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }

    public void addPlayer(Player player) {

        try {
            etx.begin();
            em.persist(player);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer(Player player) {

        try {
            etx.begin();
            em.merge(player);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(Player player) {

        try {
            etx.begin();
            em.remove(player);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPlayerToTeam(TeamPlayer teamPlayer) {

        try {
            etx.begin();
            em.persist(teamPlayer);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTeamPlayer(TeamPlayer teamPlayer) {

        try {
            etx.begin();
            em.merge(teamPlayer);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePlayerFromTeam(TeamPlayer teamPlayer) {

        try {
            etx.begin();
            em.remove(teamPlayer);
            etx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Player> findAllPlayers() {
        List<Player> players = null;
        TypedQuery<Player> playerQ;
        try {
            playerQ = em.createNamedQuery("Player.findAllPlayers", Player.class);
            players = playerQ.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return players;
    }

    public Player findPlayerByPlayerId(Player player) {
        Player existedPlayer = null;
        TypedQuery<Player> playerQ;
        try {
            playerQ = em.createNamedQuery("Player.findPlayerByPlayerId", Player.class);
            playerQ.setParameter("playerId", player.getPlayerId());
            existedPlayer = playerQ.getSingleResult();
        } catch (Exception e) {
            return existedPlayer;
        }
        return existedPlayer;
    }

    public Player findPlayerByPlayerName(Player player) {
        Player existedPlayer = null;
        TypedQuery<Player> playerQ;
        try {
            playerQ = em.createNamedQuery("Player.findPlayerByPlayerName", Player.class);
            playerQ.setParameter("playerName", player.getPlayerName());
            existedPlayer = playerQ.getSingleResult();
        } catch (Exception e) {
            return existedPlayer;
        }
        return existedPlayer;
    }

    public List<Player> findPlayersByUserName(User user) {
        List<Player> players = null;
        TypedQuery<Player> playerQ;
        try {
            playerQ = em.createNamedQuery("Player.findPlayerByUserName", Player.class);
            playerQ.setParameter("userName", user.getUserName());
            players = playerQ.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return players;
    }

    public List<Player> findPlayersByUserId(User user) {
        List<Player> players = null;
        TypedQuery<Player> playerQ;
        try {
            playerQ = em.createNamedQuery("Player.findPlayerByUserId", Player.class);
            playerQ.setParameter("userId", user.getUserId());
            players = playerQ.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return players;
    }
}
