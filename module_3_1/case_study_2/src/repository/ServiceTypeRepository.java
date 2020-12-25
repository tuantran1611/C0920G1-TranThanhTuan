package repository;

import connection.MySQLConnection;
import models.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository {
    private static final String SELECT_SERVICE_TYPE = "SELECT * FROM service_type";
    private static final String GET_SERVICE_TYPE_BY_ID = "SELECT * FROM service_type where service_type_id = ?";

    public ServiceTypeRepository() {
    }

    public ServiceType selectServiceTypeById(String id){
        ServiceType serviceType = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SERVICE_TYPE_BY_ID)
        ){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String serviceTypeName = rs.getString("service_type_name");
                serviceType = new ServiceType(id,serviceTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceType;
    }

    public List<ServiceType> selectAllServiceType(){
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("service_type_id");
                String serviceTypeName = rs.getString("service_type_name");
                serviceTypes.add(new ServiceType(id,serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }
}
