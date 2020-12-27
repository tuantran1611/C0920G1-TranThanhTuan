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
                String id1 = null;
                if (id.matches("^000[1-9]$")){
                    id1 = ("DV-").concat(id);
                } else if (id.matches("^00[1-9]\\d$")){
                    id1 = ("DV-").concat(id);
                } else if (id.matches("^0[1-9]\\d\\d$")){
                    id1 = ("DV-").concat(id);
                }
                String serviceName = rs.getString("service_name");
                String serviceArea = rs.getString("service_area");
                String serviceTypeCost = rs.getString("service_type_cost");
                String serviceMaxPeople = rs.getString("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberFloor = rs.getString("number_of_floors");
                service = new Service(id1,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,serviceType,
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
                String id1 = null;
                if (serviceId.matches("^[1-9]$")){
                    id1 = ("DV-000").concat(serviceId);
                } else if (serviceId.matches("^[1-9]\\d$")){
                    id1 = ("DV-00").concat(serviceId);
                } else if (serviceId.matches("^[1-9]\\d\\d$")){
                    id1 = ("DV-0").concat(serviceId);
                }
                String serviceName = rs.getString("service_name");
                String serviceArea = rs.getString("service_area");
                String serviceTypeCost = rs.getString("service_type_cost");
                String serviceMaxPeople = rs.getString("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberFloor = rs.getString("number_of_floors");
                serviceList.add(new Service(id1,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,
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
                String id1 = null;
                if (serviceId.matches("^[1-9]$")){
                    id1 = ("DV-000").concat(serviceId);
                } else if (serviceId.matches("^[1-9]\\d$")){
                    id1 = ("DV-00").concat(serviceId);
                } else if (serviceId.matches("^[1-9]\\d\\d$")){
                    id1 = ("DV-0").concat(serviceId);
                }
                String serviceName = rs.getString("service_name");
                String serviceArea = rs.getString("service_area");
                String serviceTypeCost = rs.getString("service_type_cost");
                String serviceMaxPeople = rs.getString("service_max_people");
                RentType rentType = rentTypeRepository .selectRentTypeById(rs.getString("rent_type_id"));
                ServiceType serviceType = serviceTypeRepository.selectServiceTypeById(rs.getString("service_type_id"));
                String standardRoom = rs.getString("standard_room");
                String descriptionConvenience = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberFloor = rs.getString("number_of_floors");
                serviceList.add(new Service(id1,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,
                        serviceType,standardRoom,descriptionConvenience,poolArea,numberFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public void addNewService(Service service){
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL_2);){
                preparedStatement.setString(1,service.getServiceId().substring(3));
                preparedStatement.setString(2, service.getServiceName());
                preparedStatement.setString(3, service.getServiceArea());
                preparedStatement.setString(4,service.getServiceTypeCost());
                preparedStatement.setString(5, service.getServiceMaxPeople());
                preparedStatement.setString(6,service.getRentType().getRentTypeId());
                preparedStatement.setString(7,service.getServiceType().getServiceTypeId());
                preparedStatement.setString(8,service.getStandardRoom());
                preparedStatement.setString(9,service.getDescriptionConvenience());
                preparedStatement.setString(10,service.getPoolArea());
                preparedStatement.setString(11,service.getNumberFloor());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
