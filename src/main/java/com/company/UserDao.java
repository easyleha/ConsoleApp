package com.company;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static UserDao instance;
    private Gson gson = new Gson();
    private List<User> users = new ArrayList<>();

    public static synchronized UserDao getInstance() {
        if (instance == null){
            instance = new UserDao();
        }
        return instance;
    }

    private UserDao(){

    }

    public void addUser( User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean update(User testUser) {
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(testUser.getFirstName())) {
                user.setSecondName(testUser.getSecondName());
                return true;
            }
        }
        return false;
    }
    public boolean remove(String name) {
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(name) || user.getSecondName().equalsIgnoreCase(name)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}