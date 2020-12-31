package services.impl;

import models.BenhAn;

import java.sql.SQLException;
import java.util.List;

public interface BenhAnService {
    public BenhAn selectBenhAn(String id);

    public List<BenhAn> selectAllBenhAn();

    public boolean deleteBenhAn(String id) throws SQLException;

    public boolean updateBenhAn(BenhAn benhAn) throws SQLException;

    public BenhAn selectBenhAn1(String id);
}
