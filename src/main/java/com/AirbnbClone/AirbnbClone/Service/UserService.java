package com.AirbnbClone.AirbnbClone.Service;

import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GetAll User

    public List<User> getAlluser(){
        return userRepository.findAll();
    }

    //createUser
    public User CreateUser(User user){
        return userRepository.save(user);
    }

    // GetUserById
    public Optional<User> getUserbyId(Long id){
        return userRepository.findById(id);
    }

    // deleteUser
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
