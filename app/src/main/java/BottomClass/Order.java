package BottomClass;

public class Order {
    private int Id;//ID
    private Customer Customer;//顾客
    private Driver Driver;//司机
    private String OrderTime;//下单时间
    private double Price;//交易金额
    private String Destination;//目的地
    private String StartingPoint;//出发点

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public BottomClass.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(BottomClass.Customer customer) {
        Customer = customer;
    }

    public BottomClass.Driver getDriver() {
        return Driver;
    }

    public void setDriver(BottomClass.Driver driver) {
        Driver = driver;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        OrderTime = orderTime;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getStartingPoint() {
        return StartingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        StartingPoint = startingPoint;
    }
}
