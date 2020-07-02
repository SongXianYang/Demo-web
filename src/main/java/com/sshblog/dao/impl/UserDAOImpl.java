package com.sshblog.dao.impl;

import com.sshblog.dao.UserDAO;
import com.sshblog.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author SongXianYang
 * @date 2020-06-29 16:13:42
 **/
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean findByUserNameAddPassWord(String cellphone, String password) {
        List<User> list;
        list = sessionFactory.getCurrentSession().createQuery("from User u where u.cellphone=:i and u.password=:p")
                .setParameter("i", cellphone).setParameter("p", password).list();
        if(list.size()==1){
            return true;
        }else{
            return false;
        }

    }


}
