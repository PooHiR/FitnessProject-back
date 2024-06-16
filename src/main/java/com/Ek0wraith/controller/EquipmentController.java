package com.Ek0wraith.controller;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Equipment;
import com.Ek0wraith.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * ClassName: EquipmentController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:46
 * @Version 1.0
 */
@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(path= "/getAllEquipment")
    public List<Equipment> getAllEquipment(int page, int size){
        return equipmentService.getAllEquipment(page,size);
    }

    @RequestMapping(path= "/addEquipment")
    public Map<String,Object> addEquipment(Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }

    @RequestMapping(path ="/updateEquipment")
    public Map<String,Object> updateEquipment(Equipment equipment){
        return equipmentService.updateEquipment(equipment);
    }

    @RequestMapping(path ="/deleteEquipment")
    public Map<String,Object> deleteEmployee(int equipmentNo){
        return equipmentService.deleteEquipment(equipmentNo);
    }

    @RequestMapping(path = "/totalEquipment")
    public Common totalEmployee() {
        return equipmentService.totalEquipment();
    }

    @RequestMapping(path = "/getByKeywordEquipment")
    public List<Equipment> getByKeywordEquipment(String keyWord, int page, int size){
        return equipmentService.getByKeywordEquipment(keyWord,page,size);
    }

    @RequestMapping(path = "/totalEquipmentFuzzy")
    public Common totalEquipmentFuzzy(String keyWord) {
        return equipmentService.totalEquipmentFuzzy(keyWord);
    }
}
