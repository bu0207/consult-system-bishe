package com.consult_system.service;

import com.consult_system.entity.User;
import com.consult_system.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private static Logger Log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;


    public int findAllBy() {
        Log.info("user表数据count:" + userRepo.findAllBy().size());
        return userRepo.findAllBy().size();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public List<User> registerUser(String name, String password, String studentId) {
        return userRepo.findUserByStudentId(studentId);
    }

    public List<User> findUserInfo(String password, String studentId, String role) {
        return userRepo.findUserInfo(password, studentId, role);
    }

}
