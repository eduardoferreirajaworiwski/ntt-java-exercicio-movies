package com.eduardojaworiwski.academiacx.facade.user;

import com.eduardojaworiwski.academiacx.dto.UserDTO;
import com.eduardojaworiwski.academiacx.entity.UserModel;
import com.eduardojaworiwski.academiacx.services.inter.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFacade {
    private final UserInterfaceService userService;

    @Autowired
    public UserFacade(UserInterfaceService userService) {
        this.userService = userService;
    }

    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserModel user = convertToUser(userDTO);
        UserModel savedUser = userService.create(user);
        UserDTO savedUserDTO = convertToUserDTO(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    public ResponseEntity<UserDTO> getUserById(Long id) {
        UserModel user = userService.findById(id);
        if (user != null) {
            UserDTO userDTO = convertToUserDTO(user);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserModel> users = userService.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    public ResponseEntity<UserDTO> updateUser(Long id, UserDTO updatedUserDTO) {
        UserModel user = convertToUser(updatedUserDTO);
        user.setId(id);
        UserModel updatedUser = userService.update(user);
        if (updatedUser != null) {
            UserDTO updatedUserDTOResponse = convertToUserDTO(updatedUser);
            return ResponseEntity.ok(updatedUserDTOResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private UserModel convertToUser(UserDTO userDTO) {
        UserModel user = new UserModel();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserDTO convertToUserDTO(UserModel user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
