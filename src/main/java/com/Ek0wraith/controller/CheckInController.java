package com.Ek0wraith.controller;

import com.Ek0wraith.pojo.CheckIn;
import com.Ek0wraith.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * ClassName: CheckController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 11:54
 * @Version 1.0
 */
@Controller
@ResponseBody
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @RequestMapping(path = "/addCheckIn")
    public Map<String,Object> addCheckIn(CheckIn checkIn){
        return checkInService.addCheckIn(checkIn);
    }
}

