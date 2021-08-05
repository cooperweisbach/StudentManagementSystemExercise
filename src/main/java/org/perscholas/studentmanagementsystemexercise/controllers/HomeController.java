package org.perscholas.studentmanagementsystemexercise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.dao.CourseRepo;
import org.perscholas.studentmanagementsystemexercise.models.Course;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.perscholas.studentmanagementsystemexercise.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.perscholas.studentmanagementsystemexercise.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
@Slf4j
@SessionAttributes("user")
public class HomeController {

    private UsersService usersService;
    private CourseService courseService;
    @Autowired
    public HomeController(UsersService usersService, CourseService courseService) {
        this.usersService = usersService;
        this.courseService = courseService;
    }

    //Homepage

    @GetMapping({"/", "/template"})
    public String index(){
        log.warn("executing...");
        return "template";
    }

    //Logging In + Logging Out


    //Registering Classes + Students



    // Getting Student Data

    @PostMapping("/console/getallstudents")
    public String postAllStudents(Model model) {
        List<Users> users = usersService.findAll();
        model.addAttribute("allusers", users);
        return "/console/getallstudents";
    }

    @GetMapping("console/getstudentbyid")
    public String studentIdSearch(Model model){
        model.addAttribute("searchedStudent", new Users());
        return "console/getstudentbyid";
    }

//    @PostMapping("")
//    public String studentIdSearchResult





   //Get All Courses + Get Course By ID
    @PostMapping ("/console/getallcourses")
    public String postAllCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);
        return "/console/getallcourses";
    }


    @GetMapping("/console/getcoursebyid")
    public String courseIdSearch(Model model){
        model.addAttribute("searchedCourse", new Course());
        return "/console/getcoursebyid";
    }

    @PostMapping("/console/coursesearchresult")
    public String courseIdSearchResult(@ModelAttribute Course course, Model model){
        Course searchedCourse = courseService.getById(course.getId());
        model.addAttribute("searchedCourse", searchedCourse);
        return "/console/coursesearchresult";
    }



//    @ModelAttribute
//    public Course generateCourse(){
//        Course course;
//        return course = new Course();
//    }
//
//    @ModelAttribute
//    public Users generateStudent(){
//        Users student;
//        return student = new Users();
//    }

    @PostConstruct
    public void init() {
        log.warn("Initialized...");
    }

    @PreDestroy
    public void destroy() {
        log.warn("destroyed...");
    }

}
