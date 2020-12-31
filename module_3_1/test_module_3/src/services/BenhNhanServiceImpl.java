package services;

import models.BenhNhan;
import repository.BenhNhanRepository;
import services.impl.BenhNhanService;

import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService {
    private BenhNhanRepository benhNhanRepository = new BenhNhanRepository();
    @Override
    public List<BenhNhan> getAllBenhNhan() {
        return benhNhanRepository.selectAllBenhNhan();
    }

    @Override
    public BenhNhan selectBenhNhanById(String id) {
        return benhNhanRepository.selectBenhNhanById(id);
    }
}
