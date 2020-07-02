package com.sshblog.dao.impl;

import com.sshblog.dao.UserloginlogDAO;
import com.sshblog.entity.Userloginlog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author SongXianYang
 * @date 2020-07-01 16:29:28
 **/
@Repository
@Transactional
public class UserloginlogDAOImpl implements UserloginlogDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void save(Userloginlog userloginlog) {
        sessionFactory.getCurrentSession().save(userloginlog);
    }
}
