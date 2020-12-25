package services.impl;

import models.Division;

import java.util.List;

public interface DivisionService {
    public Division selectDivisionById(String id);
    public List<Division> getAllDivision();
}
