package services.impl;

import models.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    public List<ServiceType> getAllServiceType();
    public ServiceType selectServiceTypeById(String id);
}
