package com.company.flatmate.service;

import com.company.flatmate.dto.UserDto;
import com.company.flatmate.entity.Role;
import com.company.flatmate.entity.User;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.repository.RoleRepository;
import com.company.flatmate.repository.UserRepository;
import com.company.flatmate.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper mapper;

    // нужно потом убрать
    public void save(UserDto user) {
        userRepository.save(mapper.dtoToUser(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        throw new NoSuchDataException();
    }

    public UserDto findById(@Nonnull UUID id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchDataException();
        }
        return mapper.userToDto(user.get());
    }


}
