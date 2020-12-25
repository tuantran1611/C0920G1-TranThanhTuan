package services;

import models.User;
import repository.UserRepository;
import services.impl.UserService;

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
}
