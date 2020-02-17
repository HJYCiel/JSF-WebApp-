package com.algonquincollege.cst8277.assignment2.controller;

/**
 * UsersController class is a manage bean for the UserDao interface
 * 
 * 
 * @date   2019/10/10
 *
 * @author Jiaying Huang 040-885-198
 *
 * @param ud: object of UserDao interface
 * @param u: object of the model - User
 * @param userlist: a list of all the data in database
 * 
 */

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.enterprise. context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algonquincollege.cst8277.assignment2.dao.UserDao;
import com.algonquincollege.cst8277.assignment2.model.User;


@Named("usersController")
@SessionScoped
public class UsersController implements Serializable{
    private static final long serialVersionUID = 1L;

    private UserDao ud;
    private User u;
    private List<User> userlist;
    private static final Logger Logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
 
    /**
     * injecting UserDao interface (bean) into current bean in order to manipulate methods in UserDao interface
     * @param usersDAO: injected bean
     * 
     * Acknowledgement: Professor Mike Norman provided this injection in assignment description
     */
    @Inject
    public UsersController(UserDao usersDAO) { 
        this.ud = usersDAO;
    }
    
    /**
     * getList() returns a list with all user info stored in data base
     * 
     * Acknowledgement: Professor Mike Norman helped with fixing and completing this method
     */
    public void getList() {  
        this.userlist = ud.readUsers();
    }
    
    /**
     * loadUser(int id) method fetches all info of a user and store it as an object with a name called "user" in SessionMap
     * @param id: the id of the selected user whose info is ready to be loaded
     * @return a form for inputting update info
     * Acknowledgement: Professor Mike Norman provided this injection in assignment description
     */

    public String loadUser(int id) {
        
        User u1 = ud.readUser(id); 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext(); 
        Map<String, Object> sessionMap = externalContext.getSessionMap(); 
        sessionMap.put("user", u1);
        
        Logger.info("loaded user placed in sessionMap");
        return "update.xhtml";
    }
    
    /**
     * prepareCreateUser() method create an empty object called "user" on SessionMap. It also replaced the object with same name on the map with an empty object
     * @return a form for creating new user by inputting new user info
     */
    public String prepareCreateUser() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext(); 
        Map<String, Object> sessionMap = externalContext.getSessionMap(); 
        sessionMap.put("user", new User());
        
        Logger.info("empty user placed in sessionMap");
        
        return "create.xhtml";
        
    }
    /**
     * creating a user
     * 
     * @param newUser: an empty object of User which is going to accept inputted info
     * @return the updated form with all info in database
     */
    public String createUsers(User  newUser) {
        ud.createUser(newUser);
        getList();
        return "list-users.xhtml";
    }
    /**
     * deleting a user
     * 
     * @param id: the id of user who is selected to be deleted
     * @return the updated form with all info in database
     */
    public String deleteUser(int id) {
        ud.deleteUser(id);
        getList();
        return "list-users.xhtml";
    }
    
/**
 * updating existing user
 * 
 * @param u: an empty object of User which is going to be loaded with the info of selected user
 * @return the updated form with all info in database
 */
   public String updateUser(User u) {
       ud.updateUser(u);
       getList();
       return "list-users.xhtml";
   }
   
/**
 * setters and getters for User and List<User>
 */
   
public User getU() {
   return ud.find(this.u.getId());
    
}

public void setU(User u) {
    this.u = u;
}

public List<User> getUsers() {
    return userlist;
}

public void setUsers(List<User> userlist) {
    this.userlist = userlist;
}


}
