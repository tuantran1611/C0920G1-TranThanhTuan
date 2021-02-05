package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.AttachService;
import vn.codegym.case_study.repository.AttachServiceRepository;
import vn.codegym.case_study.service.AttachServiceService;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
