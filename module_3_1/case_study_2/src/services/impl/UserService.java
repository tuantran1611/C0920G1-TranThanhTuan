package services.impl;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User selectUserByName(String name);
    public List<User> getAllUser();
    public void addUser(String user);
    public boolean deleteUser(String userName);
}
