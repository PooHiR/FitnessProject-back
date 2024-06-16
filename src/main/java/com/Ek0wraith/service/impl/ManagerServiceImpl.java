package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.ManagerMapper;
import com.Ek0wraith.pojo.Manager;
import com.Ek0wraith.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName: ManagerServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:54
 * @Version 1.0
 */
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public List<Manager> getAllManager() {
        return managerMapper.getAllManager();
    }
}
