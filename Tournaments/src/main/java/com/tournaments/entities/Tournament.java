package com.tournaments.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "TOURNAMENTS")
@NamedQueries({
    @NamedQuery(name = "Tournament.findTournamentsByUserId", query = "SELECT object(t) FROM Tournament t where t.user.userId = :userId"),
    @NamedQuery(name = "Tournament.findTournamentsByUserName", query = "SELECT object(t) FROM Tournament t where t.user.userName = :userName"),
    @NamedQuery(name = "Tournament.findByTournamentId", query = "SELECT object(t) FROM Tournament t where t.tournamentId = :tournamentId"),
})
public class Tournament implements Serializable {

    private int tournamentId;
    private String tournamentName;
    private Date tournamentDate;
    private String tournamentPlace;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOURNAMENT_ID")
    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Column(name = "TOURNAMENT_NAME")
    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    @Column(name = "TOURNAMENT_DATE")
    public Date getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(Date tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    @Column(name = "PLACE")
    public String getTournamentPlace() {
        return tournamentPlace;
    }

    public void setTournamentPlace(String tournamentPlace) {
        this.tournamentPlace = tournamentPlace;
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
