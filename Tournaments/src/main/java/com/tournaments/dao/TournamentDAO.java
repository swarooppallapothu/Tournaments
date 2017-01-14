/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.Tournament;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TournamentDAO {

    private EntityManagerFactory fac = null;
    private EntityManager em = null;
    private EntityTransaction transaction = null;

    public TournamentDAO() {
        fac = Persistence.createEntityManagerFactory("JPAStrutsPU", System.getProperties());
        em = fac.createEntityManager();
        transaction = em.getTransaction();
    }

    public void saveTournament(Tournament tournament) {
        try {
            transaction.begin();
            em.persist(tournament);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateTournament(Tournament tournament) {
        transaction.begin();
        em.merge(tournament);
        transaction.commit();
    }

    public void deleteTournament(Tournament tournament) {
        transaction.begin();
        em.remove(tournament);
        transaction.commit();
    }

    public List<Tournament> findAll() {
        List<Tournament> allTournaments = null;
        try {
            allTournaments = em.createQuery("SELECT OBJECT(T) FROM Tournament AS T").getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
        return allTournaments;
    }

    public List<Tournament> findTournamentsByUserId(User user) {
        TypedQuery<Tournament> tournamentQ;
        List<Tournament> allTournaments;
        try {
            tournamentQ = em.createNamedQuery("Tournament.findTournamentsByUserId", Tournament.class);
            tournamentQ.setParameter("userId", user.getUserId());
            allTournaments = tournamentQ.getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
        return allTournaments;
    }

    public List<Tournament> findTournamentsByUserName(User user) {
        TypedQuery<Tournament> tournamentQ;
        List<Tournament> allTournaments;
        try {
            tournamentQ = em.createNamedQuery("Tournament.findTournamentsByUserName", Tournament.class);
            tournamentQ.setParameter("userName", user.getUserName());
            allTournaments = tournamentQ.getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
        return allTournaments;
    }

    public Tournament getTournament(int tournamentId) {
        TypedQuery<Tournament> tournamentQ;
        Tournament tournament = null;
        try {
            tournamentQ = em.createNamedQuery("Tournament.findByTournamentId", Tournament.class);
            tournamentQ.setParameter("tournamentId", tournamentId);
            tournament = tournamentQ.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tournament;
    }
}
