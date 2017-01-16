package com.tournaments.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.dao.PlayerDAO;
import com.tournaments.entities.Player;
import com.tournaments.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class PlayerAction extends ActionSupport implements ModelDriven<Player>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private PlayerDAO playerDao = new PlayerDAO();
    private Player player = new Player();
    private List<Player> playersList = new ArrayList();
    HttpServletRequest request;
    Map parameters = ActionContext.getContext().getParameters();

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
        User user = (User)sessionMap.get("userObject");
        String ids[] = (String[]) parameters.get("loadType");
        if(user.getClearance() == 0 || "ALL".equalsIgnoreCase(ids[0])){
            playersList = playerDao.findAllPlayers();
        } else {
            playersList = playerDao.findPlayersByUserId(user);
        }

        return SUCCESS;
    }

    public String addPlayerView() {
        return SUCCESS;
    }

    public String editPlayerView() {
        String ids[] = (String[]) parameters.get("playerId");
        player = playerDao.findPlayerByPlayerId(Integer.parseInt(ids[0]));
        return SUCCESS;
    }
    
    public String addPlayer() {
        User user = (User) sessionMap.get("userObject");
        player.setUser(user);
        playerDao.addPlayer(player);
        return SUCCESS;
    }

    public String updatePlayer() {
        User user = (User) sessionMap.get("userObject");
        player.setUser(user);
        playerDao.updatePlayer(player);
        return SUCCESS;
    }

    public String deletePlayer() {
        String ids[] = (String[]) parameters.get("playerId");
        player.setPlayerId(Integer.parseInt(ids[0]));
        playerDao.deletePlayer(player);
        return SUCCESS;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player tournament) {
        this.player = tournament;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

}
