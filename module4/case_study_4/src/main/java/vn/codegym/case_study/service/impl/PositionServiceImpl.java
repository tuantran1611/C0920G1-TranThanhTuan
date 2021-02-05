package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Position;
import vn.codegym.case_study.repository.PositionRepository;
import vn.codegym.case_study.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
