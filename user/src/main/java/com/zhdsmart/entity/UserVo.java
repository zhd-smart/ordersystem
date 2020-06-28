package com.zhdsmart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {

    private int code;

    private String msg;

    private int count;

    private List<User> data;
}
