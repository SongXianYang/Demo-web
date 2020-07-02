package com.sshblog.dao;

import com.sshblog.entity.User;

/**
 * @author SongXianYang
 * @date 2020-06-29 16:08:58
 **/

public interface UserDAO {
    public void saveUser(User user);

    public boolean findByUserNameAddPassWord(String cellphone, String password);
}
