package com.sshblog.controller;

import com.sshblog.dao.UserDAO;
import com.sshblog.dao.UserloginlogDAO;
import com.sshblog.entity.User;
import com.sshblog.entity.Userloginlog;
import com.sshblog.service.UserService;
import com.sshblog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SongXianYang
 * @date 2020-06-29 17:10:09
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserloginlogDAO userloginlogDAO;

    @RequestMapping("song")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser( User users,@RequestParam("cellphone") String cellphone,
                                        @RequestParam("password")  String password
                            ) {
        String md5 = MD5Util.string2MD5(password);
        users.setCellphone(cellphone);
        users.setPassword(md5);
        userService.saveUser(users);
        return "注册成功";
    }

    @RequestMapping("loginUser")
    public String loginUser() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam("cellphone") String cellphone,
                        @RequestParam("password") String password,
                        HttpSession session, Userloginlog userloginlog,User user,HttpServletRequest request) {

//        session.setAttribute("user",user);
        request.getSession().setAttribute("user",userDAO.findByUserNameAddPassWord(cellphone, password));
        String s = MD5Util.string2MD5(password);
        System.out.println(s);
        if (userDAO.findByUserNameAddPassWord(cellphone, s)) {
            /////////////
            User userSession = (User) session.getAttribute("user");
            Date date = new Date();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            userloginlog.setLoginTime(date);
            userloginlog.setUserId(userSession.getUserId());

            userloginlog.setLoginIp("127.0.0.1");
            userloginlogDAO.save(userloginlog);
            //////////////
            return "登录成功";
        } else {
            return "失败";
        }
    }


}
