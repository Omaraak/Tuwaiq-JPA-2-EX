package com.example.jpa2ex.Repository;

import com.example.jpa2ex.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUserByUsernameAndPassword(String username, String password);
    @Query("select u from User u where u.email=?1")
    User getByEmail(String email);
    @Query("select u from User u where u.role=?1")
    List<User> getByRole(String role);
    List<User> findUserByAgeGreaterThanEqual(int age);
}
