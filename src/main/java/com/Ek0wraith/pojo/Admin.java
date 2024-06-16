package com.Ek0wraith.pojo;

import lombok.Data;

/**
 * ClassName: Admin
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 8:49
 * @Version 1.0
 */
@Data
public class Admin {
    private Integer adminNo;
    private String adminAccount;
    private  String adminPassword;
    public String token;
}
