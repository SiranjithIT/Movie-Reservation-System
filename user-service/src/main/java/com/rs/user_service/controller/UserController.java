package com.rs.user_service.controller;

import com.rs.user_service.dto.UserDto;
import com.rs.user_service.dto.UserRequest;
import com.rs.user_service.model.User;
import com.rs.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        try{
            List<UserDto> userDto = userService.getUsers();
            return ResponseEntity.ok(userDto);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id){
        try{
            UserDto userDto = userService.getUserById(id);
            return ResponseEntity.ok(userDto);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        String result = userService.addUser(user);
        if(result.contains("Exception")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDto> authenticateUser(@RequestBody UserRequest userRequest){
        try{
            UserDto userDto = userService.authenticateUser(userRequest);
            return ResponseEntity.ok(userDto);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
