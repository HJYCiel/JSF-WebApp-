package com.algonquincollege.cst8277.assignment2.dao;

/**
 * UsersDao is an interface which has all the methods needed to manipulate data from database.  The methods cover functionalities of creating a user, reading a single user or a user list,
 * finding a user, updating a user and deleting a user.
 * 
 * @date   2019/10/10
 *
 * @author Jiaying Huang 040-885-198
 * 
 * 
 */

import java.util.List;

import com.algonquincollege.cst8277.assignment2.model.User;

public interface UserDao {
    
    //create a user
    public User createUser(User u);
    
    //read a user
    public User readUser(int userId);
    
     //read user list
    public List<User> readUsers();
    
    
    //update an existing user
    public void updateUser(User u);
    
    //delete an existing user
    public void deleteUser(int userId);
    
    //locate a user
    public User find(long id);

}
