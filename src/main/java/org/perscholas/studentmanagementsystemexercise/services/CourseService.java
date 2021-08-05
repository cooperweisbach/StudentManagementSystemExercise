package org.perscholas.studentmanagementsystemexercise.services;

import org.perscholas.studentmanagementsystemexercise.models.Course;
import org.perscholas.studentmanagementsystemexercise.dao.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class CourseService {

    private CourseRepo courseRepo;
    private Course course;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Transactional
    public void saveCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public Course getById(Integer id){

        return courseRepo.getById(id);

    }

    List<Course> getByName(String name){

        return courseRepo.getByName(name);

    }

    List<Course> getByInstructor(String instructor){

        return courseRepo.getByInstructor(instructor);

    }


}
