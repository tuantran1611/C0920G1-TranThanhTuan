package repository;

import connection.MySQLConnection;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private static final String SELECT_SERVICE = "SELECT * FROM service";
    private static final String GET_SERVICE_BY_ID = "SELECT * FROM service where service_id = ?";
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + " (service_name, service_area, service_type_cost," +
            " service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) VALUES " +
            " (?,?, ?, ?,?,?,?,?,?,?)";

    private static final String INSERT_SERVICE_SQL_2 = "INSERT INTO service" + " (service_id, service_name, service_area, service_type_cost," +
            " service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) VALUES " +
            " (?,?,?, ?, ?,?,?,?,?,?,?)";
    private RentTypeRepository rentTypeRepository = new RentTypeRepository();
    private ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    public ServiceRepository() {
    }

    public Service selectServiceById(String id){
        Service service = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SERVICE_BY_ID)) {
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String serviceName = rs.getString("service_name");
                int serviceArea = rs.getInt("service_area");
                double serviceTypeCost = rs.getDouble("service_type_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_of_floors");
                service = new Service(id,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,serviceType,
                        standardRoom, descriptionConvenience,poolArea,numberFloor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public List<Service> selectServiceByName(String name) {
        List<Service> serviceList = new ArrayList<>();
        String query = "{CALL search_service(?)}";
        try (
                Connection connection = MySQLConnection.getConnection();
                CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1,name);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                String serviceId = rs.getString("service_id");
                String serviceName = rs.getString("service_name");
                int serviceArea = rs.getInt("service_area");
                double serviceTypeCost = rs.getDouble("service_type_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_of_floors");
                serviceList.add(new Service(serviceId,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,
                        serviceType,standardRoom,descriptionConvenience,poolArea,numberFloor));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public List<Service> selectAllService(){
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String serviceId = rs.getString("service_id");
                String serviceName = rs.getString("service_name");
                int serviceArea = rs.getInt("service_area");
                double serviceTypeCost = rs.getDouble("service_type_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_of_floors");
                serviceList.add(new Service(serviceId,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,
                        serviceType,standardRoom,descriptionConvenience,poolArea,numberFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public void addNewService(Service service){
        try (Connection connection = MySQLConnection.getConnection();){

            if (service.getServiceId().equals("")){
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);
                preparedStatement.setString(1, service.getServiceName());
                preparedStatement.setInt(2, service.getServiceArea());
                preparedStatement.setDouble(3,service.getServiceTypeCost());
                preparedStatement.setInt(4, service.getServiceMaxPeople());
                preparedStatement.setString(5,service.getRentType().getRentTypeId());
                preparedStatement.setString(6,service.getServiceType().getServiceTypeId());
                preparedStatement.setString(7,service.getStandardRoom());
                preparedStatement.setString(8,service.getDescriptionConvenience());
                preparedStatement.setDouble(9,service.getPoolArea());
                preparedStatement.setInt(10,service.getNumberFloor());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL_2);
                preparedStatement.setString(1,service.getServiceId());
                preparedStatement.setString(2, service.getServiceName());
                preparedStatement.setInt(3, service.getServiceArea());
                preparedStatement.setDouble(4,service.getServiceTypeCost());
                preparedStatement.setInt(5, service.getServiceMaxPeople());
                preparedStatement.setString(6,service.getRentType().getRentTypeId());
                preparedStatement.setString(7,service.getServiceType().getServiceTypeId());
                preparedStatement.setString(8,service.getStandardRoom());
                preparedStatement.setString(9,service.getDescriptionConvenience());
                preparedStatement.setDouble(10,service.getPoolArea());
                preparedStatement.setInt(11,service.getNumberFloor());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
