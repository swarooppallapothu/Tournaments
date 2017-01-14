/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.dao;

import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserDAO {

    private EntityManagerFactory fac = null;
    private EntityManager em = null;
    private EntityTransaction transaction = null;

    public UserDAO() {
        fac = Persistence.createEntityManagerFactory("JPAStrutsPU", System.getProperties());
        em = fac.createEntityManager();
        transaction = em.getTransaction();
    }

    public boolean registerUser(User user) {
        boolean isUserExists = false;
        try {
            if(findByUsername(user) == null){
               transaction.begin();
                em.persist(user);
                transaction.commit();
            }else{
                isUserExists = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUserExists;
    }

    public void updateUser(User user) {
        transaction.begin();
        em.merge(user);
        transaction.commit();
    }
    public void deleteUser(User user) {
        
        user = findByUserId(user);
        if(user != null){
        transaction.begin();
        em.remove(user);
        transaction.commit();
        }
    }

    public List<User> findAll() {
        List<User> allUsers = null;
        try {
            allUsers = em.createQuery("select object(u) from User as u").getResultList();
        } catch (Exception ex) {
            allUsers = new ArrayList();
        }
        return allUsers;
    }
    
    public User findByUsername(User user){
        TypedQuery<User> queryDevice;
        User existedUser = null;
        try {
            queryDevice = em.createNamedQuery("User.findByUsername", User.class);
            queryDevice.setParameter("userName", user.getUserName());
            existedUser = queryDevice.getSingleResult();
        } catch (NoResultException nre) {
            return existedUser;
        }
        return existedUser;
    }
    public User findByUserId(User user) {
        TypedQuery<User> queryDevice;
        User existedUser = null;
        try {
            queryDevice = em.createNamedQuery("User.findByUserId", User.class);
            queryDevice.setParameter("userId", user.getUserId());
            existedUser = queryDevice.getSingleResult();
        } catch (NoResultException nre) {
            return existedUser;
        }
        return existedUser;
    }
    public User authenticateUser(User user) {
        TypedQuery<User> queryDevice;
        User existedUser = null;
        try {
            queryDevice = em.createNamedQuery("User.authenticateUser", User.class);
            queryDevice.setParameter("userName", user.getUserName());
            queryDevice.setParameter("password", user.getPassword());
            existedUser = queryDevice.getSingleResult();
        } catch (NoResultException nre) {
            return existedUser;
        }
        return existedUser;
    }
    public User findByTeamId(User user) {
        TypedQuery<User> queryDevice;
        User existedUser = null;
        try {
            queryDevice = em.createNamedQuery("User.authenticateUser", User.class);
            queryDevice.setParameter("userId", user.getUserId());
            queryDevice.setParameter("password", user.getPassword());
            existedUser = queryDevice.getSingleResult();
        } catch (NoResultException nre) {
            return existedUser;
        }
        return existedUser;
    }
}
