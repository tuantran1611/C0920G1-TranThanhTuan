package services;

import models.EducationDegree;
import repository.EducationDegreeRepository;
import services.impl.EducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Override
    public EducationDegree selectEducationDegreeById(String id) {
        return new EducationDegreeRepository().selectEducationDegreeById(id);
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return new EducationDegreeRepository().getAllEducation();
    }
}
