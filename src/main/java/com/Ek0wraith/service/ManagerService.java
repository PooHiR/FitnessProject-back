package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ManagerService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:54
 * @Version 1.0
 */
@Service
public interface ManagerService {
    public List<Manager> getAllManager();
}
