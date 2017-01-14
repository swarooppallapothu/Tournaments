/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PLAYERS")
@NamedQueries({
    @NamedQuery(name = "Player.findAllPlayers", query = "SELECT object(P)  from Player P"),
    @NamedQuery(name = "Player.findPlayerByPlayerId", query = "SELECT object(P) from Player P where P.playerId = :playerId"),
    @NamedQuery(name = "Player.findPlayerByPlayerName", query = "SELECT object(P) from Player P where P.playerName = :playerName"),
    @NamedQuery(name = "Player.findPlayersByUserId", query = "SELECT object(P) from Player P where P.user.userId = :userId"),
    @NamedQuery(name = "Player.findPlayersByUserName", query = "SELECT object(P) from Player P where P.user.userId = :userName"),
})
public class Player implements Serializable {
    
    private int playerId;
    private String playerName;
    private User user;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PLAYER_ID")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
     @Column(name="PLAYER_NAME")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CREATED_BY", referencedColumnName = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}