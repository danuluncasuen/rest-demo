package com.walkthrough.demo.service;

import com.walkthrough.demo.db.UserDAO;
import com.walkthrough.demo.entitie.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(int id, String name, int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        if (user.getAge() < 0) {
            return;
        }
        userDAO.addUser(user);
    }

    public List<User> getUsersByName(String name) {
        List<User> usersFromDb = userDAO.getAllUsers();
        List<User> usersToBeReturned = new ArrayList<>();
        for(int i=0; i<usersFromDb.size(); i++) {
            if(usersFromDb.get(i).getName().equals(name)) {
                usersToBeReturned.add(usersFromDb.get(i));
            }
        }
        return usersToBeReturned;
    }

    public List<User> getAll() {
        return userDAO.getAllUsers();
    }
}
