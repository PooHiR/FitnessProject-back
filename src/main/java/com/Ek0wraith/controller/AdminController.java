package com.Ek0wraith.controller;

import com.Ek0wraith.service.AdminService;
import com.Ek0wraith.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * ClassName: AdminController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 9:03
 * @Version 1.0
 */
@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;

    @RequestMapping(path="/getAdminPassword")
    @CrossOrigin
    public Map<String,Object> getAdminPassword(String adminAccount,String adminPassword ) {
        return adminService.getAdminPassword(adminAccount,adminPassword);
    }

    @RequestMapping(path="/checkToken")
    @CrossOrigin
    public Boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        return JwtUtil.checkToken(token);
    }
}
