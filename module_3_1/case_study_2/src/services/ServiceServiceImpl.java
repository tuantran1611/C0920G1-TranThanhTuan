package services;

import models.Service;
import repository.ServiceRepository;
import services.impl.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Service> getAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public Service getServiceById(String id) {
        return serviceRepository.selectServiceById(id);
    }

    @Override
    public void addNewService(Service service) {
        serviceRepository.addNewService(service);
    }

    @Override
    public List<Service> selectServiceByName(String name) {
        return serviceRepository.selectServiceByName(name);
    }
}
