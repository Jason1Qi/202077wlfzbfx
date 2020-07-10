package BottomClass;

import java.util.LinkedList;


public class Driver {
    private int Id;//ID
    private String UserName;//用户名
    private String Password;//密码
    private LinkedList<Order> Orders;//订单列表
    private String ServiceType;//地址
    private String PhoneNumber;//电话号码
    private String Name;//姓名
    private Car Car;//车辆

    public Driver() {
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

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
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

    public BottomClass.Car getCar() {
        return Car;
    }

    public void setCar(BottomClass.Car car) {
        Car = car;
    }
}
