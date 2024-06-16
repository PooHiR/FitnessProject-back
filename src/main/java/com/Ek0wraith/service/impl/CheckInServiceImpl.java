package com.Ek0wraith.service.impl;

import com.Ek0wraith.pojo.CheckIn;
import com.Ek0wraith.mapper.CheckInMapper;
import com.Ek0wraith.mapper.MemberMapper;
import com.Ek0wraith.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CheckInServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 13:27
 * @Version 1.0
 */
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInMapper checkInMapper;
    private MemberMapper memberMapper;
    @Override
    public Map<String,Object> addCheckIn(CheckIn checkIn){
        Map<String,Object> resultMap = new HashMap<>();
        checkIn.setCheckDate(LocalDate.now());

        CheckIn checkInByMemberNo = checkInMapper.getCheckByMemberNo(checkIn);

        if (checkInByMemberNo != null){
            resultMap.put("message","今日已签到，请勿重复签到！");
        }else{
            int result = checkInMapper.addCheckIn(checkIn);

            if(result>0){
                //添加积分
                memberMapper.updateMemberIntegral(-1,checkIn.getMemberNo());
                resultMap.put("code",200);
                resultMap.put("message","签到成功");
            }else{
                resultMap.put("code",400);
                resultMap.put("message","签到失败");
            }
        }

        return resultMap;
    }
}
