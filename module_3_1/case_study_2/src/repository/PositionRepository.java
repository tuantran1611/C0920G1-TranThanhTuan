package repository;

import connection.MySQLConnection;
import models.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private static final String SELECT_POSITION_SQL = "SELECT * FROM `position`";
    private static final String GET_POSITION_BY_ID = "SELECT * FROM `position` where position_id = ?";

    public PositionRepository() {
    }

    public Position selectPositionById(String id){
        Position position = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_POSITION_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String position_id = rs.getString("position_id");
                String position_name = rs.getString("position_name");
                position = new Position(position_id,position_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }

    public List<Position> getAllPosition(){
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_SQL)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String position_id = rs.getString("position_id");
                String position_name = rs.getString("position_name");
                positionList.add(new Position(position_id,position_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
