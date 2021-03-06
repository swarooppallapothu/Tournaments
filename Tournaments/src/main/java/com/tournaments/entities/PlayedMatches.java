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
@Table(name = "PLAYED_MATCHES")
@NamedQueries({
    @NamedQuery(name="PlayedMatchs.findMatchById", query = "Select object(pm) from PlayedMatches pm where pm.matchId =:matchId"),
    @NamedQuery(name="PlayedMatchs.findAllMatches", query = "Select object(pm) from PlayedMatches pm"),
    @NamedQuery(name="PlayedMatchs.findMatchByUserId", query = "SELECT object(pm) from PlayedMatches pm where pm.user.userId = :userId"),
    @NamedQuery(name="PlayedMatchs.findMatchsByTournamentId", query = "SELECT object(pm) from PlayedMatches pm where pm.tournament.tournamentId = :tournamentId")
})
public class PlayedMatches implements Serializable {

    private int matchId;
    private int results;
    private String matchName;
    private Team teamA;
    private Team teamB;
    private Team winner;
    private Tournament tournament;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCH_ID")
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Column(name = "RESULTS")
    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    @Column(name = "MATCH_NAME")
    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAMA", referencedColumnName = "TEAM_ID")
    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAMB", referencedColumnName = "TEAM_ID")
    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WINNER", referencedColumnName = "TEAM_ID")
    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID")
    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
