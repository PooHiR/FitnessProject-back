package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: EmployeeMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 11:06
 * @Version 1.0
 */
@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee> getAllEmployee(int page,int size);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int employeeNo);

    Common totalEmployee();

    List<Employee> getByKeywordEmployee(String keyWord,int page,int size);

    Common totalEmployeeFuzzy(String keyWord);

    List<Employee> getAllCoach();

    List<Employee> getAllManager();

}
