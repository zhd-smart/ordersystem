package com.zhdsmart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private int orderId;

    private User user;

    private Admin admin;

    private Menu menu;

    private Date createDate;

    private int state;
}
