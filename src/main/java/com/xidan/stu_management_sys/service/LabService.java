package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.LabCreateRequest;
import com.xidan.stu_management_sys.Pojo.LabDTO;
import com.xidan.stu_management_sys.Pojo.LabUpdateRequest;

import java.util.List;

public interface LabService {
    List<LabDTO> listAllLabs();
    void updateLab(Long id, LabUpdateRequest req);
    void createLab(LabCreateRequest req);
    void deleteLab(Long id);
}
