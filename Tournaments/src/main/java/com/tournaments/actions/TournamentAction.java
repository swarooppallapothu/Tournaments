package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.dao.TournamentDAO;
import com.tournaments.entities.Tournament;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TournamentAction extends ActionSupport implements ModelDriven<Tournament>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private Tournament tournament = new Tournament();
    private TournamentDAO tournamentDao = new TournamentDAO();
    private List<Tournament> tournmentsList = new ArrayList<Tournament>();
    HttpServletRequest request;

    @Override
    public Tournament getModel() {
        return tournament;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String tournaments() {
        tournmentsList = tournamentDao.findAll();
        return SUCCESS;
    }

    public String insertTournament() {
        User user = (User) sessionMap.get("userObject");
        tournament.setUser(user);
        tournament.setTournamentDate(new Date());
        tournamentDao.saveTournament(tournament);
        return SUCCESS;
    }

    public String addTournamentView() {
        return SUCCESS;
    }

    public String editTournamentView() {
        return SUCCESS;
    }

    public String addTournament() {
        User user = (User) sessionMap.get("userObject");
        tournament.setUser(user);
        tournament.setTournamentDate(new Date());
        tournamentDao.saveTournament(tournament);
        return SUCCESS;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Tournament> getTournmentsList() {
        return tournmentsList;
    }

    public void setTournmentsList(List<Tournament> list) {
        this.tournmentsList = list;
    }
}
