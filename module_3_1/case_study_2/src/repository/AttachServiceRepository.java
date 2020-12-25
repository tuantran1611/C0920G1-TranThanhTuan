package repository;

import connection.MySQLConnection;
import models.AttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository {
    private static final String SELECT_ATTACH_SERVICE = "SELECT * FROM attach_service";
    private static final String GET_ATTACH_SERVICE_BY_ID = "SELECT * FROM attach_service where attach_service_id = ?";

    public AttachServiceRepository() {
    }

    public AttachService selectAttachServiceById(String id){
        AttachService attachService = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ATTACH_SERVICE_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String attachServiceName = rs.getString("attach_service_name");
                double cost = rs.getDouble("attach_service_cost");
                int unit  = rs.getInt("attach_service_unit");
                String status = rs.getString("attach_service_status");
                attachService = new AttachService(id,attachServiceName,cost,unit,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachService;
    }

    public List<AttachService> getAllAttachService(){
        List<AttachService> attachServiceList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("attach_service_id");
                String attachServiceName = rs.getString("attach_service_name");
                double cost = rs.getDouble("attach_service_cost");
                int unit  = rs.getInt("attach_service_unit");
                String status = rs.getString("attach_service_status");
                attachServiceList.add(new AttachService(id,attachServiceName,cost,unit,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;
    }
}
