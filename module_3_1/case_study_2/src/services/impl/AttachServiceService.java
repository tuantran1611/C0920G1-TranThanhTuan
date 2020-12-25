package services.impl;

import models.AttachService;

import java.util.List;

public interface AttachServiceService {
    public AttachService selectAttachServiceById(String id);
    public List<AttachService> getAllAttachService();
}
