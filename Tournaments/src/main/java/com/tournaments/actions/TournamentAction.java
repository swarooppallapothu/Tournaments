/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.dao.TournamentDAO;
import com.tournaments.entities.Tournament;
import com.tournaments.entities.User;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class TournamentAction extends ActionSupport implements ModelDriven<Tournament>, SessionAware {

    private Map<String, Object> sessionMap;
    private Tournament tournament = new Tournament();
    private TournamentDAO tournamentDao = new TournamentDAO();

    @Override
    public Tournament getModel() {
        return tournament;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String tournaments() {
        return SUCCESS;
    }
    
    public String addTournamentView() {
        return SUCCESS;
    }

    public String editTournamentView() {
        return SUCCESS;
    }

    public String addTournament() {
        User user = new User();
        user.setUserId(1);
        tournament.setUser(user);
        tournamentDao.saveTournament(tournament);
        return SUCCESS;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
