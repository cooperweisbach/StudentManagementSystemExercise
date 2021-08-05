package org.perscholas.studentmanagementsystemexercise;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.dao.CourseRepo;
import org.perscholas.studentmanagementsystemexercise.dao.UsersRepo;
import org.perscholas.studentmanagementsystemexercise.models.Course;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Component
@Transactional
public class AppRunner implements CommandLineRunner {
    // autowire all repo's/services
    private UsersRepo usersRepo;
    private CourseRepo courseRepo;

    @Autowired
    public AppRunner(UsersRepo usersRepo, CourseRepo courseRepo) {
        this.usersRepo = usersRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // add dummy data

        courseRepo.save(new Course("Java","Haseeb"));
        courseRepo.save(new Course("JavaScript","Young"));
        courseRepo.save(new Course("Python","Jenny"));
        courseRepo.save(new Course("Professional Development","Jaclyn"));
        courseRepo.save(new Course("Spring Framework","Jafer"));
        courseRepo.save(new Course("Agile Methodologies","Joseph"));

        usersRepo.save(new Users("BSpreine@Gmail.com","Bryant","Pa$$w0rd"));
        usersRepo.save(new Users("AFarias@Gmail.com","Allen","Pa$$word1"));
        usersRepo.save(new Users("KOriley@Gmail.com","Kate","Pa$$word2"));
        usersRepo.save(new Users("TMajumdar@Gmail.com","Tanvir","Pa$$word3"));
        usersRepo.save(new Users("CWeisbach@Gmail.com","Cooper","Pa$$word4"));
        usersRepo.save(new Users("YLing@Gmail.com","Ying","Pa$$word5"));



    }
}
