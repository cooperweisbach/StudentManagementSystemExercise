package org.perscholas.studentmanagementsystemexercise.dao;

import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,String> {

    List<Users> findAll();
    Users getById(String email);
    List<Users> findUsersByName(String name);
    List<Users> findByNameStartingWith(String substring);
//    Boolean deleteUsersById(String email);

}
