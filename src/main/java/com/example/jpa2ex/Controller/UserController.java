package com.example.jpa2ex.Controller;

import com.example.jpa2ex.Api.ApiException;
import com.example.jpa2ex.Model.User;
import com.example.jpa2ex.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ums")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(200).body(userService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.add(user);
        return ResponseEntity.status(201).body("User added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) throws ApiException {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.update(id, user);
        return ResponseEntity.status(200).body("User updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) throws ApiException {
        userService.delete(id);
        return ResponseEntity.status(200).body("User deleted successfully");
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity check(@PathVariable String username, @PathVariable String password) throws ApiException {
        return ResponseEntity.status(200).body(userService.check(username, password));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) throws ApiException {
        return ResponseEntity.status(200).body(userService.getByEmail(email));
    }

    @GetMapping("getByRole/{role}")
    public ResponseEntity getByRole(@PathVariable String role) throws ApiException {
        return ResponseEntity.status(200).body(userService.getByRole(role));
    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity getByAge(@PathVariable int age) throws ApiException {
        return ResponseEntity.status(200).body(userService.getByAge(age));
    }
}
