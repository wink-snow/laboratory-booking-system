package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.LabCreateRequest;
import com.xidan.stu_management_sys.Pojo.LabDTO;
import com.xidan.stu_management_sys.Pojo.LabUpdateRequest;
import com.xidan.stu_management_sys.mapper.LabMapper;
import com.xidan.stu_management_sys.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabMapper mapper;

    @Override
    public List<LabDTO> listAllLabs() {
        List<Map<String, Object>> flat = mapper.findAllLabFlat();

        List<LabDTO> result = new ArrayList<>();
        for (Map<String, Object> row : flat) {
            LabDTO dto = new LabDTO();
            dto.setLabId(((Number) row.get("labId")).longValue());
            dto.setLabName((String) row.get("labName"));
            dto.setDescription((String) row.get("description"));
            dto.setRoomNumber((String) row.get("roomNumber"));
            dto.setStartTime(String.valueOf(row.get("startTime")));
            dto.setEndTime(String.valueOf(row.get("endTime")));
            dto.setStatus(((Number) row.get("status")).intValue());
            dto.setCreatedAt((String) row.get("createdAt"));
            dto.setLabTypeName((String) row.get("labTypeName"));

            LabDTO.AdminInfo admin = new LabDTO.AdminInfo(
                    (String) row.get("adminName"),
                    (String) row.get("adminPhone")
            );
            dto.setAdmin(admin);

            result.add(dto);
        }
        return result;
    }
    @Override
    public void updateLab(Long id, LabUpdateRequest req) {

        int updated = mapper.updateLab(id, req);

    }
    @Override
    public void createLab(LabCreateRequest req) {
        int rows = mapper.insertLab(
                req.getLabName(),
                req.getDescription(),
                req.getRoomNumber(),
                req.getStartTime(),
                req.getEndTime(),
                req.getStatus(),
                req.getLabAdminId(),
                req.getLabTypeId()
        );
        if (rows != 1) {
            throw new RuntimeException("新增实验室失败");
        }
    }

    @Override
    public void deleteLab(Long id) {
        int affectedRows = mapper.deleteLabById(id);
        if (affectedRows == 0) {
            throw new RuntimeException("删除失败，未找到ID为 " + id + " 的实验室");
        }
    }



}
