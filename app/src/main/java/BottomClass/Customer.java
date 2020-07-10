package BottomClass;

import java.util.LinkedList;


public class Customer {
    private int Id;//ID
    private String UserName;//用户名
    private String Password;//密码
    private LinkedList<Order> Orders;//订单列表
    private String Address;//常用地址
    private String PhoneNumber;
    private String Name;//顾客姓名
    private Purse Purse;//钱包

    public Customer()
    {
        this.Orders=new LinkedList<Order>();

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LinkedList<Order> getOrders() {
        return Orders;
    }

    public void setOrders(LinkedList<Order> orders) {
        Orders = orders;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BottomClass.Purse getPurse() {
        return Purse;
    }

    public void setPurse(BottomClass.Purse purse) {
        Purse = purse;
    }
}
