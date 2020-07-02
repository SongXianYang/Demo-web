package com.sshblog.controller;

import com.sshblog.dao.UserloginlogDAO;
import com.sshblog.entity.User;
import com.sshblog.entity.Userloginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SongXianYang
 * @date 2020-07-01 15:10:48
 **/
@Controller
@RequestMapping("log")
public class UserloginlogWEB {

    @Autowired
    UserloginlogDAO userloginlogDAO;

    @RequestMapping("userLoginLog")
    public void userLoginLog(HttpSession session,Userloginlog userloginlog) {
        User user1 = (User) session.getAttribute("user");
        Date date = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        userloginlog.setLoginTime(date);
        userloginlog.setUserId(user1.getUserId());
        userloginlog.setLoginIp("192.168.31.1");
        userloginlogDAO.save(userloginlog);
    }
}
