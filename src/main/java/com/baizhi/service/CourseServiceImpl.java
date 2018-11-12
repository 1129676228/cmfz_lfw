package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAllCourse() {
        List<Course> list = courseDao.queryAllCourse();
        return list;
    }

    @Override
    public void insertCourse(Course course) {
       courseDao.saveCourse(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseDao.removeCourse(id);
    }
}
