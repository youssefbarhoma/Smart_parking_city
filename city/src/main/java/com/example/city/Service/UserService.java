package com.example.city.Service;

import com.example.city.Repository.UserRepository;
import org.springframework.stereotype.Service;

/*@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse registerUser(RegisterUserRequest request) {

        // rule: unique email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        // Factory creates the object
        User user = UserFactory.createUser(request);

        // Save it
        User saved = userRepository.save(user);

        // Convert to DTO
        return convertToResponse(saved);
    }

    private UserResponse convertToResponse(User saved) {
        UserResponse response = new UserResponse();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole());
        return response;
    }
}
*/