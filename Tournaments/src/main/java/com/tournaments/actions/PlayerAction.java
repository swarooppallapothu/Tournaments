package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.Player;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class PlayerAction extends ActionSupport implements ModelDriven<Player>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private Player player = new Player();
    HttpServletRequest request;

    @Override
    public Player getModel() {
        return player;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String players() {
        return SUCCESS;
    }

    public String addPlayerView() {
        return SUCCESS;
    }

    public String editPlayerView() {
        return SUCCESS;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player tournament) {
        this.player = tournament;
    }
}
