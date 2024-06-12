package com.Ek0wraith.entity;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: Member
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 9:08
 * @Version 1.0
 */
@Data
public class Member {
    @Alias("用户编号")
    private Integer memberNo;
    @Alias("用户名")
    private String memberUsername;
    @JsonIgnore
    private String memberPassword;
    @Alias("姓名")
    private String memberName;
    @Alias("年龄")
    private Integer memberAge;
    @Alias("性别")
    private String memberGender;
    @Alias("电话")
    private String memberPhone;
    @Alias("开卡时间")
    private LocalDateTime cardTime;
    @Alias("身高")
    private Double memberHeight;
    @Alias("体重")
    private Double memberWeight;
    @Alias("购买课时")
    private Integer cardClass;
    @Alias("剩余课时")
    private Integer cardNextClass;
    @Alias("积分")
    private Integer memberIntegral;
    @Alias("余额")
    private Integer memberChange;
    @Alias("个性签名")
    private String personalizedSignature;
    @Alias("用户权限")
    private String memberPower;
    private String token;
}
