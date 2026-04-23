// Leen Salaheddin Service UID: 400003496
package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.model.User;
import org.example.assignment1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);

    }

    public List<User> getUserByFirstName(String firstName){
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Integer id, User updatedUser){
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();

            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

            return userRepository.save(existingUser);

        }
        return null;
    }

    @Transactional
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

}
