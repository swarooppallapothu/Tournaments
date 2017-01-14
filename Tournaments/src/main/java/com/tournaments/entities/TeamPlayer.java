//package com.tournaments.entities;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "TEAM_PLAYERS")
//@NamedQueries({
//    @NamedQuery(name = "TeamPlayer.findAllTeamPlayers", query = "SELECT object(tp) from TeamPlayer tp"),
//    @NamedQuery(name = "TeamPlayer.findAllTeamPlayersByTeamId", query = "SELECT object(tp) from TeamPlayer tp where tp.team.teamId = :teamId")
//    
//})
//public class TeamPlayer implements Serializable {
//
//    private int teamPlayerId;
//    private Team team;
//    private Player player;
//
//    @Id
//    @Column(name = "TEAM_PLAYER_ID")
//    public int getTeamPlayerId() {
//        return teamPlayerId;
//    }
//
//    public void setTeamPlayerId(int teamPlayerId) {
//        this.teamPlayerId = teamPlayerId;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TEAM_ID")
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PLAYER_ID")
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//
//}
