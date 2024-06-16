package com.Ek0wraith.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: Employee
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 9:02
 * @Version 1.0
 */
@Data
public class Employee {
    private Integer employeeNo;
    private String employeeName;
    private Integer employeeAge;
    private String employeeGender;
    private String employeePhone;
    private LocalDateTime employeeTime;
    private String employeeJob;
    private String employeeMessage;
}
