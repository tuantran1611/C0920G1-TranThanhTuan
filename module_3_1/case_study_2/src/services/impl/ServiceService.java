package services.impl;

import models.Service;

import java.util.List;

public interface ServiceService {
    public List<Service> getAllService();
    public Service getServiceById(String id);
    public void addNewService(Service service);
    public List<Service> selectServiceByName(String name);
}
