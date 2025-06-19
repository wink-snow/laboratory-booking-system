package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.LabBriefDTO;
import com.xidan.stu_management_sys.Pojo.LabCategoryDTO;
import com.xidan.stu_management_sys.mapper.LabCategoryMapper;
import com.xidan.stu_management_sys.service.LabCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LabCategoryServiceImpl implements LabCategoryService {
    @Autowired
    private LabCategoryMapper mapper;
    @Override
    public List<LabCategoryDTO> listCategoriesWithLabs() {
        List<Map<String, Object>> flat = mapper.findCategoryFlat();

        // 把扁平结果组装成 “分类 -> labs” 结构
        Map<Long, LabCategoryDTO> bucket = new LinkedHashMap<>();
        for (Map<String, Object> row : flat) {
            Long   typeId    = ((Number) row.get("typeId")).longValue();
            String typeName  = (String)  row.get("typeName");
            Long   labId     = ((Number) row.get("labId")).longValue();

            LabCategoryDTO dto = bucket.computeIfAbsent(typeId, id ->
                    new LabCategoryDTO(id, typeName, new ArrayList<>())
            );

            dto.getLabs().add(new LabBriefDTO(
                    labId,
                    (String) row.get("labName"),
                    (String) row.get("adminName"),
                    (String) row.get("roomNumber")
            ));
        }
        return new ArrayList<>(bucket.values());
    }
}
