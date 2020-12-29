package services;

import models.User;
import repository.UserRepository;
import services.impl.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User selectUserByName(String name) {
        return new UserRepository().selectUserByName(name);
    }

    @Override
    public List<User> getAllUser() {
        return new UserRepository().getAllUser();
    }

    @Override
    public void addUser(String user) {
        new UserRepository().addUser(user);
    }

    @Override
    public boolean deleteUser(String userName) {
        return new UserRepository().deleteUser(userName);
    }
}
