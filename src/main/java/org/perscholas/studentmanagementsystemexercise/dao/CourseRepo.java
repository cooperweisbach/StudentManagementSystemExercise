package org.perscholas.studentmanagementsystemexercise.dao;

import java.util.List;
import org.perscholas.studentmanagementsystemexercise.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findAll();
    Course getById(Integer id);
    List<Course> getByName(String name);
    List<Course> getByInstructor(String instructor);
}
