package repository;

import connection.MySQLConnection;
import models.BenhAn;
import models.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository {
    private static final String SELECT_BENHAN_BY_ID = "select idBenhAn, idBenhNhan, ngayNhapVien, " +
            "ngayRaVien, lyDoNhapVien from benhan where idBenhAn =?";
    private static final String SELECT_ALL_BENHAN = "select * from benhan";
    private static final String DELETE_BENHAN_SQL = "delete from benhan where idBenhAn = ?;";
    private static final String UPDATE_BENHAN_SQL = "update benhan set tenBenhNhan= ?, ngayNhapVien = ?, ngayRaVien = ?, " +
            "lyDoNhapVien = ? where idBenhAn = ?";
    private BenhNhanRepository benhNhanRepository = new BenhNhanRepository();

    public BenhAnRepository() {
    }

    public boolean updateBenhAn(BenhAn benhAN) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BENHAN_SQL)) {
            statement.setString(1, benhAN.getTenBenhNhan().getTenBenhNhan());
            statement.setString(2, benhAN.getNgayNhapVien());
            statement.setString(3, benhAN.getNgayRaVien());
            statement.setString(4, benhAN.getLyDoNhapVien());
            statement.setString(5,benhAN.getLyDoNhapVien());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<BenhAn> selectAllBenhAn() {
        List<BenhAn> benhAns = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHAN)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String idBenhAn = rs.getString("idBenhAn");
                BenhNhan idBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                BenhNhan tenBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                String ngayNhapVien = rs.getString("ngayNhapVien");
                String ngayRaVien = rs.getString("ngayRaVien");

                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date date1 = null;
                java.util.Date date2 = null;
                try {
                    date1 = dt.parse(ngayNhapVien);
                    date2 = dt.parse(ngayRaVien);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                String birthday1 = dt1.format(date1);
                String birthday2 = dt1.format(date2);
                String lyDoNhapVien = rs.getString("lyDoNhapVien");

                benhAns.add(new BenhAn(idBenhAn,idBenhNhan,tenBenhNhan,birthday1,birthday2,lyDoNhapVien));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            MySQLConnection.close();
        }
        return benhAns;
    }

    public boolean deleteBenhAn(String id) {
        boolean rowDeleted = false;
        try {
            try (Connection connection = MySQLConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_BENHAN_SQL)) {
                statement.setString(1, id);
                System.out.println(statement);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.close();
        }
        return rowDeleted;
    }



    public BenhAn selectBenhAn(String id) {
        BenhAn benhAn = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHAN_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String idBenhAn = rs.getString("idBenhAn");
                BenhNhan idBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                BenhNhan tenBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                String ngayNhapVien = rs.getString("ngayNhapVien");
                String ngayRaVien = rs.getString("ngayRaVien");

                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date date1 = null;
                java.util.Date date2 = null;
                try {
                    date1 = dt.parse(ngayNhapVien);
                    date2 = dt.parse(ngayRaVien);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                String birthday1 = dt1.format(date1);
                String birthday2 = dt1.format(date2);
                String lyDoNhapVien = rs.getString("lyDoNhapVien");

                benhAn = new BenhAn(idBenhAn,idBenhNhan,tenBenhNhan,birthday1,birthday2,lyDoNhapVien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            MySQLConnection.close();
        }
        return benhAn;
    }

    public BenhAn selectBenhAn1(String id) {
        BenhAn benhAn = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHAN_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String idBenhAn = rs.getString("idBenhAn");
                BenhNhan idBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                BenhNhan tenBenhNhan = benhNhanRepository.selectBenhNhanById(rs.getString("idBenhNhan"));
                String ngayNhapVien = rs.getString("ngayNhapVien");
                String ngayRaVien = rs.getString("ngayRaVien");
                String lyDoNhapVien = rs.getString("lyDoNhapVien");

                benhAn = new BenhAn(idBenhAn,idBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            MySQLConnection.close();
        }
        return benhAn;
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
