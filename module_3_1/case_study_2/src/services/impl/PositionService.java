package services.impl;

import models.Position;

import java.util.List;

public interface PositionService {
    public Position selectPositionById(String id);
    public List<Position> getAllPosition();
}
