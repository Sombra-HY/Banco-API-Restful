package com.banco.demo.service.Impl;

import com.banco.demo.model.User;
import com.banco.demo.repository.UserRepository;
import com.banco.demo.service.UserService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
    private UserRepository userRep;

    public UserServiceImple(UserRepository userRep) {
        this.userRep = userRep;
    }

    @Override
    public User findbyId(Long id) {
        return userRep.findById(id)
                .orElseThrow(NoSuchElementException :: new);
    }

    @Override
    public User create(User user) {
        if(user.getId() != null && userRep.existsById(user.getId())){
            throw new IllegalStateException("This user id already exists");
        }
        return userRep.save(user);
    }
}
