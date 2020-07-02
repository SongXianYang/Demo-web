package com.sshblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userloginlog")
@Data
public class Userloginlog {

  @Id// 声明当前私有属性为主键
  @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
  @Column
  private Integer loginId;
  @Basic
  @Column(name = "user_id")
  private Integer userId;
  @Basic
  @Column(name = "login_time")
  private Date loginTime;
  @Basic
  @Column(name = "login_ip")
  private String loginIp;
  @Transient
  private User user;


}
