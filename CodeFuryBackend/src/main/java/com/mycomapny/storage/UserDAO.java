package com.mycomapny.storage;

import com.mycomapny.business.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
