package com.myownapp.masteringjwt.repositories;

import com.myownapp.masteringjwt.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<List<User>> findByFirstname(String firstname);
    List<User> findByOrderById();
}
