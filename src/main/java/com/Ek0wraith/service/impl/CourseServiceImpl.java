package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.CourseMapper;
import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Course;
import com.Ek0wraith.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CourseServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 14:24
 * @Version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course>getAllCourse(int page,int size){
        return courseMapper.getAllCourse(page,size);
    }

    @Override
    public List<Course> getAllCourseRegister() {
        return courseMapper.getAllCourseRegister();
    }

    @Override
    public double getCoursePrisePriceByCourseNo(int courseNo) {
        return courseMapper.getCoursePriceByCourseNo(courseNo);
    }

    @Override
    public Map<String, Object> addCourse(Course course) {
        Map<String,Object> resultMap = new HashMap<>();

        int result =  courseMapper.addCourse(course);

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
    public Map<String, Object> updateCourse(Course employee) {
        Map<String,Object> resultMap = new HashMap<>();
        int result = courseMapper.updateCourse(employee);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","修改成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","修改失败");
        }

        return resultMap;

    }

    @Override
    public Map<String, Object> deleteCourse(int courseNo) {
        Map<String,Object> resultMap = new HashMap<>();
        int result = courseMapper.deleteCourse(courseNo);

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
    public Common totalCourse() {
        return courseMapper.totalCourse();
    }

    @Override
    public List<Course> getByKeywordCourse(String keyWord, int page, int size) {
        return courseMapper.getByKeywordCourse(keyWord,page,size);
    }

    @Override
    public Common totalCourseFuzzy(String keyWord) {
        return courseMapper.totalCourseFuzzy(keyWord);
    }

}
