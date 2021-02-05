package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.model.Position;

public interface PositionService {
    Iterable<Position> findAll();
}
