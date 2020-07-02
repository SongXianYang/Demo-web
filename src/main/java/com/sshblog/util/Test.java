package com.sshblog.util;

import com.sshblog.entity.Userloginlog;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SongXianYang
 * @date 2020-06-30 16:54:18
 **/
public class Test {
    public static void main(String[] args) {
        String a = "aaaa123";
        String md5Password = DigestUtils.md5DigestAsHex(a.getBytes());
        System.out.println(md5Password);
        System.out.println(MD5Util.string2MD5(a));
        System.out.println(MD5Util.convertMD5(MD5Util.convertMD5(a)));
        Userloginlog userloginlog = new Userloginlog();
        Date date = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        System.out.println(format.format(date));
    }
}

