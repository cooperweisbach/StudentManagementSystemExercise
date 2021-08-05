package org.perscholas.studentmanagementsystemexercise.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.dao.UsersRepo;
import org.perscholas.studentmanagementsystemexercise.dao.CourseRepo;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.perscholas.studentmanagementsystemexercise.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class UsersService {

    // autowire repo
    @Autowired
    private UsersRepo userRepo;
    // add services


    public UsersService(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public void saveUser(Users user){
        
        userRepo.save(user);
    }

    public List<Users> findAll(){

        return userRepo.findAll();

    }

    public Users getById(String uEmail) {

        return userRepo.getById(uEmail);

    }

    public List<Users> findUsersByName(String name) {

        return userRepo.findUsersByName(name);

    }

    List<Users> findByNameStartingWith(String substring){

        return userRepo.findByNameStartingWith(substring);
    }

//    Boolean deleteUsersById(String email) {
//
//        return userRepo.deleteUsersById(email);
//
//    }


}
