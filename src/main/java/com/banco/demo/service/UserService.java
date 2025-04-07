package com.banco.demo.service;

import com.banco.demo.model.User;

public interface UserService {
    User findbyId(Long id);
    User create(User user);

}
