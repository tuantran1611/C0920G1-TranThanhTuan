package services.impl;

import models.User;

import java.util.List;

public interface UserService {
    public User selectUserByName(String name);
    public List<User> getAllUser();
}
