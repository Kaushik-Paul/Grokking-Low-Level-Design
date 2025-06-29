package com.example.lowleveldesign.inventorymanagementsystem.controllers.user;

import com.example.lowleveldesign.inventorymanagementsystem.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public UserController(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public User getUser(int userId) {
        for (User user : this.users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
