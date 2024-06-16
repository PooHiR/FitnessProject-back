package com.Ek0wraith.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName: CheckIn
 * Package: com.Ek0wraith.Entity
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/12 8:58
 * @Version 1.0
 */
@Data
public class CheckIn {
    private Integer checkNo;
    private Integer memberNo;
    private LocalDate checkDate;

}
