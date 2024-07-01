package com.project.unijobs.service;

import com.project.unijobs.dto.UserDTO;
import com.project.unijobs.entity.User;
import com.project.unijobs.mapper.UserMapper;
import com.project.unijobs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO partialUpdate(Integer id,
                                 UserDTO userDTO) {
        User user = findById(id);
        userDTO.setId(id);
        userMapper.partialUpdate(user, userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO getById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    private User findById(Integer id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}