package com.Ek0wraith.controller;

import com.Ek0wraith.pojo.Manager;
import com.Ek0wraith.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName: ManagerController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:56
 * @Version 1.0
 */
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/getAllManager")
    public List<Manager> getAllManager() {
        return managerService.getAllManager();
    }
}
