package BottomClass;

import java.util.LinkedList;


public class Purse {
    private int Id;//ID
    private double Account;//账户余额
    private int Integral;//积分
    private LinkedList<Ticket> Tickets;//券

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getAccount() {
        return Account;
    }

    public void setAccount(double account) {
        Account = account;
    }

    public int getIntegral() {
        return Integral;
    }

    public void setIntegral(int integral) {
        Integral = integral;
    }

    public LinkedList<Ticket> getTickets() {
        return Tickets;
    }

    public void setTickets(LinkedList<Ticket> tickets) {
        Tickets = tickets;
    }
}
