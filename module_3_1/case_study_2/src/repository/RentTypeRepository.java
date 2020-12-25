package repository;

import connection.MySQLConnection;
import models.RentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository {
    private static final String SELECT_RENT_TYPE = "SELECT * FROM rent_type";
    private static final String GET_RENT_TYPE_BY_ID = "SELECT * FROM rent_type where rent_type_id = ?";

    public RentTypeRepository() {
    }

    public RentType selectRentTypeById(String id){
        RentType rentType = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_RENT_TYPE_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String rentTypeName = rs.getString("rent_type_name");
                Double rentTypeCost = rs.getDouble("rent_type_cost");
                rentType = new RentType(id,rentTypeName,rentTypeCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentType;
    }

    public List<RentType> selectAllRentType(){
        List<RentType> rentTypeList = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("rent_type_id");
                String rentTypeName = rs.getString("rent_type_name");
                Double rentTypeCost = rs.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(id,rentTypeName,rentTypeCost));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rentTypeList;
    }
}
