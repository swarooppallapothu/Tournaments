package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.Team;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TeamAction extends ActionSupport implements ModelDriven<Team>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private Team team = new Team();
    HttpServletRequest request;

    @Override
    public Team getModel() {
        return team;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
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
