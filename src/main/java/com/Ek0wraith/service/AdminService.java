package com.Ek0wraith.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName: AdminServices
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:29
 * @Version 1.0
 */
@Service
public interface AdminService {

    public Map<String,Object> getAdminPassword(String adminAccount, String adminPassword);
}
