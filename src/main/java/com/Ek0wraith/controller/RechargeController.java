package com.Ek0wraith.controller;

import com.Ek0wraith.pojo.Recharge;
import com.Ek0wraith.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * ClassName: RechargeController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/21 10:47
 * @Version 1.0
 */
@RestController
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @RequestMapping(path="/getRechargeByMemberNo")
    public List<Recharge> getRechargeByMemberNo(int memberNo){
        return rechargeService.getRechargeByMemberNo(memberNo);
    }

    @RequestMapping(path = "/addRechargeByMemberNo")
    public Map<String,Object> addRechargeByMemberNo(Recharge recharge) {
        return rechargeService.addRechargeByMemberNo(recharge);
    }





}
