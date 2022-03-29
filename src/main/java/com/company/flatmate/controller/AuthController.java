package com.company.flatmate.controller;

import com.company.flatmate.entity.User;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.jwt.JwtProvider;
import com.company.flatmate.security.payload.AuthRequest;
import com.company.flatmate.security.payload.AuthResponse;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.security.payload.RegistrationRequest;
import com.company.flatmate.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegistrationRequest request) {
        User user = new User()
                    .setFirstname(request.getFirstname())
                    .setLogin(request.getLogin())
                    .setPassword(request.getPassword())
                    .setCity(request.getCity())
                    .setEmail(request.getEmail());
        userService.saveUser(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if (user != null) {
            String token = jwtProvider.generateToken(user.getLogin());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.notFound().build();
    }
}
