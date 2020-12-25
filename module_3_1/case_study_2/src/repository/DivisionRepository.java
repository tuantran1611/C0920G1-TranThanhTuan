package repository;

import connection.MySQLConnection;
import models.Division;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository {
    private static final String SELECT_DIVISION_SQL = "SELECT * FROM division";
    private static final String GET_DIVISION_BY_ID = "SELECT * FROM division where division_id = ?";

    public Division selectDivisionById(String id){
        Division division = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DIVISION_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String division_id = rs.getString("division_id");
                String division_name = rs.getString("division_name");
                division = new Division(division_id,division_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }

    public List<Division> getAllDivision(){
        List<Division> divisionList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION_SQL)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String division_id = rs.getString("division_id");
                String division_name = rs.getString("division_name");
                divisionList.add(new Division(division_id,division_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  divisionList;
    }
}
