package com.Ek0wraith.service.impl;

import com.Ek0wraith.pojo.Admin;
import com.Ek0wraith.mapper.AdminMapper;
import com.Ek0wraith.service.AdminService;
import com.Ek0wraith.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * ClassName: AdminServicesImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:31
 * @Version 1.0
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Map<String,Object> getAdminPassword(String adminAccount, String adminPassword){
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
