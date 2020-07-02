package com.sshblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

  @Id// 声明当前私有属性为主键
  @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
  @Column
  private Integer userId;
  @Basic
  @Column(name = "user_name")
  private String userName;
  @Basic
  @Column(name = "email")
  private String email;
  @Basic
  @Column(name = "callphone")
  private String cellphone;
  @Basic
  @Column(name = "password")
  private String password;
  @Basic
  @Column(name = "salt")
  private String salt;
  @Basic
  @Column(name = "satate")
  private Integer state;
  @Basic
  @Column(name = "create_time")
  private Date createTime;



}
