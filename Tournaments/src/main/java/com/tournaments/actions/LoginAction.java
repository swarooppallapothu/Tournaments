/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tournaments.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.User;
import com.tournaments.dao.UserDAO;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements ModelDriven<User>, SessionAware {

    private Map<String, Object> sessionMap;
    private User user = new User();
    private UserDAO userDao = new UserDAO();
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getLoginPage() {
        return SUCCESS;
    }
    public String getUserRegistrationPage() {
        return SUCCESS;
    }

    public String registerUser() {
            userDao.registerUser(user);
            return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
