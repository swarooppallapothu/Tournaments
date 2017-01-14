/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
@NamedQueries({
		@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
                @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.userName = :userName"),
                @NamedQuery(name = "User.findByTeamId", query = "SELECT u FROM User u WHERE u.userName = :userName"),
                @NamedQuery(name = "User.authenticateUser", query = "SELECT u FROM User u WHERE u.userName = :userName and u.password = :password")

})
public class User implements Serializable{
    
    private int userId;
    private String userName;
    private String password;
    private int  clearance = 1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
     @Column(name="USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
     @Column(name="CLEARANCE")
    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }
    
    
}
