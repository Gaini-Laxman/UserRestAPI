package com.klinnovations.service;

import java.util.List;
import com.klinnovations.entity.User;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User deleteUser(int id);
    List<User> getAllUser();
}
