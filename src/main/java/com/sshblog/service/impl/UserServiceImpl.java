package com.sshblog.service.impl;

import com.sshblog.dao.UserDAO;
import com.sshblog.entity.User;
import com.sshblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author SongXianYang
 * @date 2020-06-29 16:17:50
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }
}
