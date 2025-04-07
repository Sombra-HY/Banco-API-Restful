package com.banco.demo.service;

import com.banco.demo.model.User;

public interface UserService {
    User finbyId(Long id);
    User create(User user);

}
