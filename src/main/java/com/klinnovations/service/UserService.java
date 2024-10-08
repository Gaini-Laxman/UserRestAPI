package com.klinnovations.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.klinnovations.entity.User;

@Service
public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User deleteUser(int id);
    List<User> getAllUser();
}
