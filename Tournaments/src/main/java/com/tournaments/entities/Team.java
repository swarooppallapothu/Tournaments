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
@Table(name = "TEAMS")
@NamedQueries({
    @NamedQuery(name = "Team.findTeamsByUserId", query="SELECT object(T) from Team T where T.user.userId = :userId"),
    @NamedQuery(name = "Team.findTeamsByUserName", query="SELECT object(T) from Team T where T.user.userName = :userName"),
    @NamedQuery(name = "Team.findByTeamId", query = "SELECT object(t) FROM Team t where t.teamId = :teamId")
})
public class Team implements Serializable {

    private int teamId;
    private String teamName;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Column(name = "TEAM_NAME")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
