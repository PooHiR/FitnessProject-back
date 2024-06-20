package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.ManagedOperation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CourseService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 14:16
 * @Version 1.0
 */
public interface CourseService {
    public List<Course> getAllCourse(int page,int size);
    public List<Course> getAllCourseRegister();
    public double getCoursePriseByCourseNo(int courseNo);
    public Map<String,Object> addCourse(Course course);
    public Map<String,Object> updateCourse(Course employee);
    public Map<String,Object> deleteCourse(int courseNo);
    public Common totalCourse();
    public List<Course> getByKeywordCourse(String keyWord,int page,int size);
    public Common totalCourseFuzzy(String keyWord);
}
