package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;

import java.util.List;


public interface LaboratoryService {
    List<Laboratory> findAvailable();
    Result createLab(Laboratory lab);
    Result updateLab(Long id, Laboratory lab);
    Result deleteLab(Long id);


}
