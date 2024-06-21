package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.CourseMapper;
import com.Ek0wraith.mapper.MemberMapper;
import com.Ek0wraith.mapper.RechargeMapper;
import com.Ek0wraith.mapper.RegisterMapper;
import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import com.Ek0wraith.pojo.Recharge;
import com.Ek0wraith.pojo.Register;
import com.Ek0wraith.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: RechargeServiceImple
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/17 9:07
 * @Version 1.0
 */
@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeMapper rechargeMapper;

    @Override
    public List<Recharge> getRechargeByMemberNo(int memberNo){
        return rechargeMapper.getRechargeByMemberNo(memberNo);
    }

    @Override
    public Map<String, Object> addRechargeByMemberNo(Recharge recharge) {
        //充值时间
        recharge.setRechargeDate(LocalDate.now());
        System.out.println(LocalDate.now());

        recharge.setRechargeMethod("在线充值");
        recharge.setRechargeStatus(1);

        Map<String,Object> resultMap = new HashMap<>();

        int result = rechargeMapper.addRechargeByMemberNo(recharge);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","充值成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","充值失败");
        }

        return resultMap;
    }
}
