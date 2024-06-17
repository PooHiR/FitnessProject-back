package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.EmployeeMapper;
import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Employee;
import com.Ek0wraith.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: EmployeeServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 11:05
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAllEmployee(int page, int size){
        return employeeMapper.getAllEmployee(page,size);
    }

    @Override
    public Map<String,Object> addEmployee(Employee employee){
        Map<String,Object> resultMap = new HashMap<>();

        /*设置入职时间*/
        employee.setEmployeeTime(LocalDateTime.now());

        int result =  employeeMapper.addEmployee(employee);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","添加成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","添加失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateEmployee(Employee employee) {
        Map<String, Object> resultMap = new HashMap<>();
        int result = employeeMapper.updateEmployee(employee);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "修改成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "修改失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteEmployee(int employeeNo) {
        Map<String,Object> resultMap = new HashMap<>();
        int result =  employeeMapper.deleteEmployee(employeeNo);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","删除成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","删除失败");
        }

        return resultMap;
    }

    @Override
    public Common totalEmployee() {
        return employeeMapper.totalEmployee();
    }

    @Override
    public List<Employee> getByKeywordEmployee(String keyWord, int page, int size) {
        return  employeeMapper.getByKeywordEmployee(keyWord,page,size);
    }

    @Override
    public Common totalEmployeeFuzzy(String keyWord) {
        return employeeMapper.totalEmployeeFuzzy(keyWord);
    }

    @Override
    public List<Employee> getAllCoach() {
        return employeeMapper.getAllCoach();
    }

    @Override
    public List<Employee> getAllManager() {
        return employeeMapper.getAllManager();
    }
}
