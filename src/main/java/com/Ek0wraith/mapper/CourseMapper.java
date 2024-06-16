package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: CourseMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 13:53
 * @Version 1.0
 */
@Mapper
@Repository
public interface CourseMapper {
    List<Course> getAllCourse(int page, int size);

    List<Course> getAllCourseRegister();

    int addCourse(Course course);

    double getCoursePriceByCourseNo(int CourseNo);

    int updateCourse(Course course);

    int deleteCourse(int courseNo);

    Common totalCourse();

    List<Course> getByKeywordCourse(String keyWord, int page, int size);

    Common totalCourseFuzzy(String keyWord);
}
