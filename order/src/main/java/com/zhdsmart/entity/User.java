package com.zhdsmart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int userId;

    private String userName;

    private String password;

    private String nickName;

    private String gender;

    private String mobile;

    private Date registerDate;

    private String address;
}
