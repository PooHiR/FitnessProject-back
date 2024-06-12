package com.Ek0wraith.entity;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: course
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 8:51
 * @Version 1.0
 */
@Data
public class Course {
    private Integer courseNo;
    private String courseName;
    private Date courseTime;
    private String courseDuration;
    private double coursePrice;
    private String courseDesc;
    private int courseIntegral;
    private Integer employeeNo;
    private Integer managerNo;
    private String employeeNameCoach;
    private String employeePhoneCoach;
    private String employeeNameManager;
    private String employeePhoneManager;
}
