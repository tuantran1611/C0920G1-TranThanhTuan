package services.impl;

import models.BenhNhan;

import java.util.List;

public interface BenhNhanService {
    public List<BenhNhan> getAllBenhNhan();
    public BenhNhan selectBenhNhanById(String id);
}
