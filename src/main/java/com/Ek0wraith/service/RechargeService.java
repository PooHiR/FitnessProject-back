package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Recharge;
import com.Ek0wraith.pojo.Register;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: RechargeService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/17 9:05
 * @Version 1.0
 */
public interface RechargeService {
    public List<Recharge> getRechargeByMemberNo(int memberNo);
    public Map<String,Object> addRechargeByMemberNo(Recharge recharge);
}
