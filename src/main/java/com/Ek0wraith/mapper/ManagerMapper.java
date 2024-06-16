package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: ManagerMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:52
 * @Version 1.0
 */
@Mapper
public interface ManagerMapper {
    List<Manager> getAllManager();
}
