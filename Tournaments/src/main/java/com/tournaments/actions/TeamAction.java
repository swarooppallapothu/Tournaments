/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.Team;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class TeamAction extends ActionSupport implements ModelDriven<Team>, SessionAware {

    private Map<String, Object> sessionMap;
    private Team team = new Team();

    @Override
    public Team getModel() {
        return team;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String teams() {
        return SUCCESS;
    }

    public String addTeamView() {
        return SUCCESS;
    }

    public String editTeamView() {
        return SUCCESS;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team tournament) {
        this.team = tournament;
    }
}
