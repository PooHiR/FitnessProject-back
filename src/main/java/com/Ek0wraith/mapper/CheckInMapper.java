package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.CheckIn;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: CheckInMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 11:59
 * @Version 1.0
 */
@Mapper
public interface CheckInMapper {

    int addCheckIn(CheckIn checkIn);

    CheckIn getCheckByMemberNo(CheckIn checkIn);
}
