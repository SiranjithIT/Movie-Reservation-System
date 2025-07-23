package com.rs.user_service.service;

import com.rs.user_service.dto.UserDto;
import com.rs.user_service.dto.UserRequest;
import com.rs.user_service.model.User;
import com.rs.user_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private UserDto ConvertToDTO(User user){
        return new UserDto(user.getId(), user.getFirstName(), user.getUserName(), user.getGender());
    }

    public List<UserDto> getUsers(){
        return userRepo.findAll().stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(UUID id){
        return userRepo.findById(id)
                .map(this::ConvertToDTO)
                .orElse(null);
    }

    public String addUser(User user){
        try{
            userRepo.save(user);
            return "Added successfully";
        }
        catch (Exception exc){
            return "Exception occurred: " + exc.getMessage();
        }
    }

    public UserDto authenticateUser(UserRequest userRequest){
        Optional<User> userOpt = userRepo.findByUserName(userRequest.getUsername());
        if(userOpt.isPresent()){
            User user = userOpt.get();
            if(user.getPassword().equals(userRequest.getPassword())){
                return ConvertToDTO(user);
            }
        }
        throw new RuntimeException("User not found");
    }
}
