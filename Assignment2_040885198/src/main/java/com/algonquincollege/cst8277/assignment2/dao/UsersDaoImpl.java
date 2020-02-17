package com.algonquincollege.cst8277.assignment2.dao;

/**
 * UsersDaoImpl class implement methods listed in UserDao interface. Methods include create user, reading a single user or a user list,
 * find a user, update a user and delete a user from database.
 * 
 * @date   2019/10/10
 *
 * @author Jiaying Huang 040-885-198
 *
 * @param em: EntityManage object. It was used to manipulate data stored in database. In this class, it was used to create, read, update and delete users.
 * 
 */
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algonquincollege.cst8277.assignment2.model.User;
import com.algonquincollege.cst8277.assignment2.dao.UserDao;


@Named
@ApplicationScoped
public class UsersDaoImpl implements UserDao, Serializable {
    private static final Logger Logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName="assignment2-PU")
    protected EntityManager em;
   
    /**
     * createUser method create a transaction between database and inputs
     * it saves user input to database
     * 
     * @param u: new user created by input via create.xhtml
     * @return the created user
     * 
     * Acknowledgement: professor Dr. Jamil Dimassi helped with Loggers and method
     */
    
    @Override
    @Transactional
    public User createUser(User u) {
        Logger.info("saving user {} to database",u.getId());
        em.persist(u);
        return u;
    }
   
    /**
     * readUser method reads all info of a specific user which located by userId
     * 
     * @param userId: The id of the user whose info is selected to be fetched
     * @return the selected user
     * 
     * Acknowledgement: professor Dr. Jamil Dimassi helped with Loggers and method
     */

    @Override
    public User readUser(int userId) {
        Logger.info("searching for a user {} from database",userId);
        User u = new User();
        u=em.find(User.class, userId);
        return u;
    }

    /**
     * readUsers method reads all info of all users in database
     * @return a list with all users
     * 
     * Acknowledgement: classmate Nicholas assist with the query
     */
    @Override
    public List<User> readUsers() {
        Logger.info("searching for all user from database");
            Query q = em.createQuery("SELECT u from User u");
            return q.getResultList();
    }

    /**
     * updateUser method create a transaction between database and inputs
     * it updates existing data in database and merge it with the new info
     * 
     * @param u: updated user info inputed via update.xhtml
     * 
     */
    @Override
    @Transactional
    public void updateUser(User u) {
        Logger.info("updating a user {} from database",u.getId());
        em.merge(u);
        
    }
    /**
     * find method locates a specific user by using its id
     * 
     * @param id: The id of the selected user
     * @return the selected user
     * 
     */
    
    @Override
    @Transactional
    public User find(long id) {
        Logger.info("locating a user {} from database",id);
        return em.find(User.class, id);
    }
    
    /**
     * deleteUser method create a transaction between database and inputs
     * it removes the selected info from database
     * 
     * @param userId: The id of the user which is selected to be removed
     * 
     */
    @Override
    @Transactional
    public void deleteUser(int userId) {
        Logger.info("deleting a user {} from database",userId);
       em.remove(em.find(User.class, userId));
        
        
    }
   
    }



    


