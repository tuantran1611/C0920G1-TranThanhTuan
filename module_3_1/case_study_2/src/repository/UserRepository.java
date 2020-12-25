package repository;

import connection.MySQLConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String SELECT_USER = "SELECT * FROM `user`";
    private static final String GET_USER_BY_NAME = "SELECT * FROM `user` where username = ?";

    public User selectUserByName(String name){
        User user = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME)){
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userName = rs.getString("username");
                String passWord = rs.getString("password");
                user = new User(userName,passWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String userName = rs.getString("username");
                String passWord = rs.getString("password");
                userList.add(new User(userName,passWord));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
