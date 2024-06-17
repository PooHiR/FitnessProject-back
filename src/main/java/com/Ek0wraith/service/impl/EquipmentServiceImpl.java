package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.EquipmentMapper;
import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Equipment;
import com.Ek0wraith.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: EquipmentServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:34
 * @Version 1.0
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> getAllEquipment(int page, int size) {
        return equipmentMapper.getAllEquipment(page,size);
    }

    @Override
    public Map<String, Object> addEquipment(Equipment equipment) {
        Map<String,Object> resultMap = new HashMap<>();

        int result =  equipmentMapper.addEquipment(equipment);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","添加成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","添加失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> updateEquipment(Equipment equipment) {
        Map<String,Object> resultMap = new HashMap<>();
        int result =  equipmentMapper.updateEquipment(equipment);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","修改成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","修改失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteEquipment(int equipmentNo) {
        Map<String,Object> resultMap = new HashMap<>();
        int result =  equipmentMapper.deleteEquipment(equipmentNo);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","删除成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","删除失败");
        }

        return resultMap;
    }

    @Override
    public Common totalEquipment() {
        return equipmentMapper.totalEquipment();
    }

    @Override
    public List<Equipment> getByKeywordEquipment(String keyWord, int page, int size) {
        return  equipmentMapper.getByKeywordEquipment(keyWord,page,size);
    }

    @Override
    public Common totalEquipmentFuzzy(String keyWord) {
        return equipmentMapper.totalEquipmentFuzzy(keyWord);
    }
}
