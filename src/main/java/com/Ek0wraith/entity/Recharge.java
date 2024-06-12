package com.Ek0wraith.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName: Recharge
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 9:12
 * @Version 1.0
 */
@Data
public class Recharge {
    private Integer rechargeNo;
    private LocalDate rechargeDate;
    private String rechargeMethod;
    private Integer rechargeStatus;
    private Double rechargeMoney;
    private Integer memberNo;

}
