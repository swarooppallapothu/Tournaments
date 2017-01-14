package com.tournaments.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.User;
import com.tournaments.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction extends ActionSupport implements ModelDriven<User>, SessionAware {

    private Map<String, Object> sessionMap;
    private User user = new User();
    private UserDAO userDao = new UserDAO();
    private List<User> users = new ArrayList();

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getUserRegistrationPage() {
        return SUCCESS;
    }

    public String registerUser() {
        user.setClearance(1);
        userDao.registerUser(user);
        return SUCCESS;
    }

    public String users() {
        this.setUsers(userDao.findAll());

        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
