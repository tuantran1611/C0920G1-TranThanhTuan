package repository;

import connection.MySQLConnection;
import models.BenhAn;
import models.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository {
    private static final String SELECT_BENHNHAN = "SELECT * FROM benhnhan";
    private static final String GET_BENHNHAN_BY_ID = "SELECT * FROM benhnhan where idBenhNhan = ?";
    private static final String UPDATE_BENHNHAN_SQL = "update benhan set tenBenhNhan= ? where idBenhNhan = ?";

    public BenhNhanRepository() {
    }

    public boolean updateBenhNhan(BenhNhan benhNhan) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BENHNHAN_SQL)) {
            statement.setString(1, benhNhan.getTenBenhNhan());
            statement.setString(2,benhNhan.getIdBenhNhan());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public BenhNhan selectBenhNhanById(String id){
        BenhNhan benhNhan = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BENHNHAN_BY_ID)
        ){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String idBenhNhan = rs.getString("idBenhNhan");
                String tenBenhNhan = rs.getString("tenBenhNhan");
                benhNhan = new BenhNhan(idBenhNhan,tenBenhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.close();
        }
        return benhNhan;
    }

    public List<BenhNhan> selectAllBenhNhan(){
        List<BenhNhan> benhNhanList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHNHAN)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String idBenhNhan = rs.getString("idBenhNhan");
                String tenBenhNhan = rs.getString("tenBenhNhan");
                benhNhanList.add(new BenhNhan(idBenhNhan,tenBenhNhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhNhanList;
    }
}
