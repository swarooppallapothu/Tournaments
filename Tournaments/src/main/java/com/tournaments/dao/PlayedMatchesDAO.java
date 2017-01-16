package com.tournaments.dao;

import com.tournaments.entities.PlayedMatches;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PlayedMatchesDAO {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction etx = null;

    public PlayedMatchesDAO() {
        emf = Persistence.createEntityManagerFactory("JPAStrutsPU", System.getProperties());
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }

    public void createMatch(PlayedMatches pm) {
        etx.begin();
        em.persist(pm);
        etx.commit();
    }

    public void updateMatch(PlayedMatches pm) {
        etx.begin();
        em.merge(pm);
        etx.commit();
    }

    public void deleteMatch(PlayedMatches pm) {
        pm = findMatchById(pm);
        if (pm != null) {
            etx.begin();
            em.remove(pm);
            etx.commit();
        }
    }

    public PlayedMatches findMatchById(PlayedMatches pm) {

        TypedQuery<PlayedMatches> tpmQ;
        try {
            tpmQ = em.createNamedQuery("PlayedMatchs.findMatchById", PlayedMatches.class);
            tpmQ.setParameter("matchId", pm.getMatchId());
            pm = tpmQ.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return pm;
    }

    public List<PlayedMatches> findAllMatches() {

        List<PlayedMatches> allMatches = null;
        try {
            allMatches = em.createNamedQuery("PlayedMatchs.findAllMatches", PlayedMatches.class).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return allMatches;
    }

    public List<PlayedMatches> findMatchByUserId(User user) {

        TypedQuery<PlayedMatches> tpmQ;
        List<PlayedMatches> allMatches = null;
        try {
            tpmQ = em.createNamedQuery("PlayedMatchs.findMatchByUserId", PlayedMatches.class);
            tpmQ.setParameter("userId", user.getUserId());
            allMatches = tpmQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return allMatches;
    }
    public List<PlayedMatches> findMatchsByTournamentId(int tournamentId) {

        TypedQuery<PlayedMatches> tpmQ;
        List<PlayedMatches> allMatches = null;
        try {
            tpmQ = em.createNamedQuery("PlayedMatchs.findMatchsByTournamentId", PlayedMatches.class);
            tpmQ.setParameter("tournamentId", tournamentId);
            allMatches = tpmQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return allMatches;
    }
}
