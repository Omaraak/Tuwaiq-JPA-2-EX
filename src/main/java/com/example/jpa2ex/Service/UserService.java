package com.example.jpa2ex.Service;

import com.example.jpa2ex.Api.ApiException;
import com.example.jpa2ex.Model.User;
import com.example.jpa2ex.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(Integer id, User user) throws ApiException {
        User userToUpdate = userRepository.findUserById(id);
        if(userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setRole(user.getRole());
            userToUpdate.setAge(user.getAge());
            userRepository.save(userToUpdate);
        }
        throw new ApiException("user not found");
    }

    public void delete(int id) throws ApiException {
        User userToDelete = userRepository.findUserById(id);
        if(userToDelete != null) {
            userRepository.delete(userToDelete);
        }
        throw new ApiException("user not found");
    }

    public User check(String username, String password) throws ApiException {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            throw new ApiException("user not found");
        }
        return user;
    }

    public User getByEmail(String email) throws ApiException {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new ApiException("user not found");
        }
        return user;
    }

    public List<User> getByRole(String role) throws ApiException {
        List<User> users = userRepository.getByRole(role);
        if (users == null) {
            throw new ApiException("user not found");
        }
        return users;
    }

    public List<User> getByAge(int age) throws ApiException {
        List<User> users = userRepository.findUserByAgeGreaterThanEqual(age);
        if (users == null) {
            throw new ApiException("user not found");
        }
        return users;
    }
}
