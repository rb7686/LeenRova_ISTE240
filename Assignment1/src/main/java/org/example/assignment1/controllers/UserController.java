// Leen Salaheddin Controller UID: 400003496

package org.example.assignment1.controllers;

import org.example.assignment1.model.User;
import org.example.assignment1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){ return userService.getAllUsers(); }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> getUser(@RequestParam String firstName){
        return userService.getUserByFirstName(firstName);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        this.userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}