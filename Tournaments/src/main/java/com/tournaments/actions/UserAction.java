package com.tournaments.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tournaments.entities.User;
import com.tournaments.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction extends ActionSupport implements ModelDriven<User>, SessionAware, ServletRequestAware {

    private Map<String, Object> sessionMap;
    private User user = new User();
    private UserDAO userDao = new UserDAO();
    private List<User> users = new ArrayList();
    HttpServletRequest request;

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUserRegistrationPage() {
        return SUCCESS;
    }

    public String getEditUserRegistrationPage() {
        String userId = this.request.getParameter("userId");
        if (userId != null) {
            User curUser = new User();
            curUser.setUserId(Integer.parseInt(userId));
            this.user = userDao.findByUserId(curUser);
            if (this.user == null) {
                return ERROR;
            }
            return SUCCESS;
        } else {
            return ERROR;
        }
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

    public String editUser() {
        userDao.updateUser(user);
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
