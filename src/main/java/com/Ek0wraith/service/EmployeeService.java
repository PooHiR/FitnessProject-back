package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: EmployeeService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 11:02
 * @Version 1.0
 */
@Service
public interface EmployeeService {
    public List<Employee> getAllEmployee(int page,int size);
    public Map<String, Object> addEmployee(Employee employee);
    public Map<String,Object> updateEmployee(Employee employee);
    public Map<String,Object> deleteEmployee(int employeeNo);
    public Common totalEmployee();
    public List<Employee> getByKeywordEmployee(String keyWord, int page, int size);
    public Common totalEmployeeFuzzy(String keyWord);
    public List<Employee> getAllCoach();
    public List<Employee> getAllManager();


}
