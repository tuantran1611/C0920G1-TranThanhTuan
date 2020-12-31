package services;

import models.BenhAn;
import repository.BenhAnRepository;
import services.impl.BenhAnService;

import java.sql.SQLException;
import java.util.List;

public class BenhAnServiceImpl implements BenhAnService {

    private BenhAnRepository benhAnRepository = new BenhAnRepository();

    @Override
    public BenhAn selectBenhAn(String id) {
        return benhAnRepository.selectBenhAn(id);
    }

    @Override
    public List<BenhAn> selectAllBenhAn() {
        return benhAnRepository.selectAllBenhAn();
    }

    @Override
    public boolean deleteBenhAn(String id) throws SQLException {
        return benhAnRepository.deleteBenhAn(id);
    }

    @Override
    public boolean updateBenhAn(BenhAn benhAn) throws SQLException {
        return benhAnRepository.updateBenhAn(benhAn);
    }

    @Override
    public BenhAn selectBenhAn1(String id) {
        return benhAnRepository.selectBenhAn1(id);
    }
}
