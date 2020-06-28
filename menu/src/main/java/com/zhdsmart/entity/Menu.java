package com.zhdsmart.entity;

import lombok.Data;

@Data
public class Menu {

    private int menuId;

    private String menuName;

    private double price;

    private String flavor;

    private Type type;
}
