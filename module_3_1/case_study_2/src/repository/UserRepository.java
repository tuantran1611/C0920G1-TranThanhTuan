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
    private static final String INSERT_USER_SQL = "INSERT INTO `user`" + "  (username,`password`) VALUES " +
            " (?,?);";
    private static final String SELECT_USER = "SELECT * FROM `user`";
    private static final String GET_USER_BY_NAME = "SELECT * FROM `user` where username = ?";
    private static final String DELETE_USER = "DELETE FROM `user` WHERE username = ?";

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

    public void addUser(String user){
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, "111111");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean deleteUser(String userName){
        boolean rowDeleted = false;
        try {
            try (Connection connection = MySQLConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
                statement.setString(1, userName);
                System.out.println(statement);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
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

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
