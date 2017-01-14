/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.Team;
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
public class TeamsDAO {

    private EntityManagerFactory fac = null;
    private EntityManager em = null;
    private EntityTransaction tx = null;

    public TeamsDAO() {
        fac = Persistence.createEntityManagerFactory("JPAStrutsPU", System.getProperties());
        em = fac.createEntityManager();
        tx = em.getTransaction();
    }

    public void addTeam(Team team) {

        try {
            tx.begin();
            em.persist(team);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTeam(Team team) {

        try {
            tx.begin();
            em.merge(team);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTeam(Team team) {

        try {
            tx.begin();
            em.remove(team);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Team> findAllTeams(){
        
        List<Team> teamsList = null;
        try{
            teamsList = em.createQuery("select object(T) from Team T").getResultList();
        }catch(Exception e){
            return new ArrayList<>();
        }
        return teamsList;
    }
    public List<Team> findTeamsByUserId(User user){
        
        List<Team> teamsList = null;
        TypedQuery teamQ;
        try{
            teamQ = em.createNamedQuery("Team.findTeamsByUserId", Team.class);
            teamQ.setParameter("userId", user.getUserId());
            teamsList = teamQ.getResultList();
        }catch(Exception e){
            return new ArrayList<>();
        }
        return teamsList;
    }
    public List<Team> findTeamsByUserName(User user){
        
        List<Team> teamsList = null;
        TypedQuery teamQ;
        try{
            teamQ = em.createNamedQuery("Team.findTeamsByUserName", Team.class);
            teamQ.setParameter("userName", user.getUserName());
            teamsList = teamQ.getResultList();
        }catch(Exception e){
            return new ArrayList<>();
        }
        return teamsList;
    }
    public List<TeamPlayer> findAllTeamPlayers(){
        
        List<TeamPlayer> teamPlayers = null;
        TypedQuery<TeamPlayer> teamPlayerQ;
        try{
            teamPlayerQ = em.createNamedQuery("TeamPlayer.findAllTeamPlayers", TeamPlayer.class);
            teamPlayers = teamPlayerQ.getResultList();
        }catch(Exception e){
            return new ArrayList<>();
        }
        return teamPlayers;
    }
   
    public List<TeamPlayer> findAllTeamPlayersByTeamId(Team team){
        
        List<TeamPlayer> teamPlayers = null;
        TypedQuery<TeamPlayer> teamPlayerQ;
        try{
            teamPlayerQ = em.createNamedQuery("TeamPlayer.findAllTeamPlayersByTeamId", TeamPlayer.class);
            teamPlayerQ.setParameter("teamId", team.getTeamId());
            teamPlayers = teamPlayerQ.getResultList();
        }catch(Exception e){
            return new ArrayList<>();
        }
        return teamPlayers;
    }
   
}
