package com.Ek0wraith.service;

import com.Ek0wraith.pojo.CheckIn;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName: CheckInService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 11:56
 * @Version 1.0
 */
public interface CheckInService {
    public Map<String,Object> addCheckIn(CheckIn checkIn);
}
