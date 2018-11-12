package com.baizhi.dao;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> queryAllCourse();

    void saveCourse(Course course);

    void removeCourse(String id);
}
