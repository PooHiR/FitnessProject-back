package com.Ek0wraith.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName: Register
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 9:13
 * @Version 1.0
 */
@Data
public class Register {
    private Integer registerNo;
    private Integer courseNo;
    private Integer memberNo;
    private String courseName;
    private LocalDate courseTime;
    private Integer courseDuration;
    private Integer employeeNo;
    private String employeeName;
    private String employeePhone;
    private String memberName;
    private String memberPhone;
}
