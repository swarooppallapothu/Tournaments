package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.dao.TeamsDAO;
import com.tournaments.entities.Team;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TeamAction extends ActionSupport implements ModelDriven<Team>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private TeamsDAO teamDao = new TeamsDAO();
    private Team team = new Team();
    private List<Team> teamsList = new ArrayList();
    private Map<String, String> teamMap = new LinkedHashMap();
    Map parameters = ActionContext.getContext().getParameters();
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
        User user = (User)sessionMap.get("userObject");
        String ids[] = (String[]) parameters.get("loadType");
        if(user.getClearance() == 0 || (ids != null && "ALL".equalsIgnoreCase(ids[0]))){
        teamsList = teamDao.findAllTeams();
        }else{
        teamsList = teamDao.findTeamsByUserId(user);
        }
        
        this.setTeamsList(teamsList);
        return SUCCESS;
    }
    
    public String getTeamsMap() {
        User user = (User)sessionMap.get("userObject");
        if(user.getClearance() == 0){
        teamsList = teamDao.findAllTeams();
        }else{
        teamsList = teamDao.findTeamsByUserId(user);
        }
        teamMap = new LinkedHashMap<String, String>();
        for (Team currTeam : teamsList) {
            teamMap.put(currTeam.getTeamId() + "", currTeam.getTeamName());
        }
        this.setTeamMap(teamMap);
        return "json";
    }

    public String addTeamView() {
        return SUCCESS;
    }

    public String editTeamView() {
        String ids[] = (String[]) parameters.get("teamId");
        team = teamDao.getTeam(Integer.parseInt(ids[0]));
        return SUCCESS;
    }

    public String addTeam() {
        User user = (User) sessionMap.get("userObject");
        team.setUser(user);
        teamDao.addTeam(team);
        return SUCCESS;
    }

    public String updateTeam() {
        User user = (User) sessionMap.get("userObject");
        team.setUser(user);
        teamDao.updateTeam(team);
        return SUCCESS;
    }

    public String deleteTeam() {
        String ids[] = (String[]) parameters.get("teamId");
        team.setTeamId(Integer.parseInt(ids[0]));
        teamDao.deleteTeam(team);
        return SUCCESS;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<String, String> getTeamMap() {
        return teamMap;
    }

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }

    public void setTeamMap(Map<String, String> teamMap) {
        this.teamMap = teamMap;
    }

}
