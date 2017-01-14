package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.dao.PlayedMatchesDAO;
import com.tournaments.entities.PlayedMatches;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TournamentDetailsAction extends ActionSupport implements ModelDriven<PlayedMatches>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private PlayedMatchesDAO playedMatchesDAO = new PlayedMatchesDAO();
    private PlayedMatches playerMatches = new PlayedMatches();
    private List<PlayedMatches> playedMaptchesList = new ArrayList();
    HttpServletRequest request;
    Map parameters = ActionContext.getContext().getParameters();

    @Override
    public PlayedMatches getModel() {
        return playerMatches;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String tournamentDetails() {
        playedMaptchesList = playedMatchesDAO.findAllMatches();
        return SUCCESS;
    }

    public String addTournamentDetailsView() {
        return SUCCESS;
    }

    public String editTournamentDetailsView() {
        String ids[] = (String[]) parameters.get("playdMatchId");
        playerMatches.setMatchId(Integer.parseInt(ids[0]));
        playerMatches = playedMatchesDAO.findMatchById(playerMatches);
        return SUCCESS;
    }

    public String addTournamentDetails() {
        User user = (User) sessionMap.get("userObject");
        playerMatches.setUser(user);
        playedMatchesDAO.createMatch(playerMatches);
        return SUCCESS;
    }

    public String updateTournamentDetails() {
        User user = (User) sessionMap.get("userObject");
        playerMatches.setUser(user);
        playedMatchesDAO.updateMatch(playerMatches);
        return SUCCESS;
    }

    public String deleteTournamentDetails() {
        String ids[] = (String[]) parameters.get("playdMatchId");
        playerMatches.setMatchId(Integer.parseInt(ids[0]));
        playedMatchesDAO.deleteMatch(playerMatches);
        return SUCCESS;
    }

    public PlayedMatches getPlayerMatches() {
        return playerMatches;
    }

    public void setPlayerMatches(PlayedMatches playerMatches) {
        this.playerMatches = playerMatches;
    }

    public List<PlayedMatches> getPlayedMaptchesList() {
        return playedMaptchesList;
    }

    public void setPlayedMaptchesList(List<PlayedMatches> playedMaptchesList) {
        this.playedMaptchesList = playedMaptchesList;
    }

}
