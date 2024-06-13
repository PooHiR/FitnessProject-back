package com.Ek0wraith.mapper;

import com.Ek0wraith.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName: AdminMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 8:54
 * @Version 1.0
 */
@Mapper
@Repository
public interface AdminMapper {
    Admin getAdminPassword(String adminAccount, String adminPassword);
}
