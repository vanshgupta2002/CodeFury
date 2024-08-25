package com.mycomapny.services;


import com.mycomapny.business.User;
import com.mycomapny.exceptions.UserNotFoundException;
import com.mycomapny.storage.UserDAO;
import com.mycomapny.storage.UserDAOImpl;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        User user = userDAO.getUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with email " + email + " not found.");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
