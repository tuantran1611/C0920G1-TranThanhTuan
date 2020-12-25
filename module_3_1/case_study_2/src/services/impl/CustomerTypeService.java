package services.impl;

import models.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    public List<CustomerType> getAll();

    public CustomerType getCusTypeById(String id);
}
