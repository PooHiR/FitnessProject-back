package com.Ek0wraith.service;

import com.Ek0wraith.entity.Admin;
import com.Ek0wraith.mapper.AdminMapper;
import com.Ek0wraith.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AdminService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 8:53
 * @Version 1.0
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    public Map<String,Object> getAdminPassword(String adminAccount,String adminPassword){
        Map<String,Object> resultMap = new HashMap<>();
        Admin result = adminMapper.getAdminPassword(adminAccount,adminPassword);

        if(result != null){
            result.setToken(JwtUtil.createToken());
            resultMap.put("token",result.getToken());
            resultMap.put("adminAccount",adminAccount);
            resultMap.put("code",200);
            resultMap.put("message","登录成功");

        }else{
            resultMap.put("code",400);
            resultMap.put("message","登录失败");
            resultMap.put("token",null);
        }
        return resultMap;
    }

}
