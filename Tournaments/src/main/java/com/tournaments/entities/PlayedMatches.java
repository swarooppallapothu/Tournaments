package com.tournaments.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYED_MATCHES")
public class PlayedMatches implements Serializable {

    private int matchId;
    private int results;
    private Team team1;
    private Team team2;
    private Tournament tournament;
    private User user;

    @Id
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM1", referencedColumnName = "TEAM_ID")
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM2", referencedColumnName = "TEAM_ID")
    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
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
