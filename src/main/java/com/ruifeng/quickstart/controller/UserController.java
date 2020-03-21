package com.ruifeng.quickstart.controller;


import com.ruifeng.quickstart.dto.RegisterDto;
import com.ruifeng.quickstart.entity.User;
import com.ruifeng.quickstart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_DEV','ROLE_PM','ROLE_ADMIN')")
    public ResponseEntity<Page<User>> getAllUser(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<User> allUser = userService.getAllUser(pageNum, pageSize);
        return ResponseEntity.ok().body(allUser);
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUserName(username);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterDto registerDto) {
        userService.saveUser(registerDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{username}/{role}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity updateRole(@PathVariable String username, @PathVariable String role) {
        userService.updateRoleByUsername(username, role);
        return ResponseEntity.ok().build();
    }
}
