package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import com.Ek0wraith.pojo.Recharge;
import com.Ek0wraith.pojo.Register;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: RechargeMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/17 9:01
 * @Version 1.0
 */
@Mapper
@Repository
public interface RechargeMapper {
    List<Recharge> getRechargeByMemberNo(int memberNo);

    int addRechargeByMemberNo(Recharge recharge);
}
