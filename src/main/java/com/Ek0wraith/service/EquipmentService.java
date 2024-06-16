package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: EquipmentService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:32
 * @Version 1.0
 */
@Service
public interface EquipmentService {
    public List<Equipment> getAllEquipment(int page, int size);
    public Map<String,Object> addEquipment(Equipment equipment);
    public Map<String,Object>  updateEquipment(Equipment equipment);
    public Map<String,Object>  deleteEquipment(int equipmentNo);
    public Common totalEquipment();
    public List<Equipment> getByKeywordEquipment(String keyWord,int page,int size);
    public  Common totalEquipmentFuzzy(String keyWord);
}
