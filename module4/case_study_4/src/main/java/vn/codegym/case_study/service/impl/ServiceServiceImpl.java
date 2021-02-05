package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.repository.ServiceRepository;
import vn.codegym.case_study.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Iterable<vn.codegym.case_study.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public vn.codegym.case_study.model.Service findById(String id) {
        return serviceRepository.getOne(id);
    }

    @Override
    public void save(vn.codegym.case_study.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }
}
