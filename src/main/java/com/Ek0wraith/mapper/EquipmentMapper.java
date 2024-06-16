package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: EquipmentMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:35
 * @Version 1.0
 */
@Mapper
@Repository
public interface EquipmentMapper {
    List<Equipment> getAllEquipment(int page, int size);

    int addEquipment(Equipment equipment);

    int updateEquipment(Equipment equipment);

    int deleteEquipment(int equipmentNo);

    Common totalEquipment();

    List<Equipment> getByKeywordEquipment(String keyWord,int page,int size);

    Common totalEquipmentFuzzy(String keyWord);
}
