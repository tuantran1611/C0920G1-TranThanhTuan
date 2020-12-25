package repository;

import connection.MySQLConnection;
import models.EducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository {
    private static final String SELECT_EDUCATION_DEGREE = "SELECT * FROM education_degree";
    private static final String GET_EDUCATION_DEGREE_BY_ID = "SELECT * FROM education_degree where education_degree_id = ?";

    public EducationDegreeRepository() {
    }

    public List<EducationDegree> getAllEducation(){
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String education_degree_id = rs.getString("education_degree_id");
                String education_degree_name = rs.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(education_degree_id,education_degree_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }

    public EducationDegree selectEducationDegreeById(String id){
        EducationDegree educationDegree = null;
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_EDUCATION_DEGREE_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String education_degree_id = rs.getString("education_degree_id");
                String education_degree_name = rs.getString("education_degree_name");
                educationDegree = new EducationDegree(education_degree_id,education_degree_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }
}
