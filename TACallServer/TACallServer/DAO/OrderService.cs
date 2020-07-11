using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TACallServer.Models;

namespace TACallServer.DAO
{
    public class OrderService
    {
        private readonly ServerContext serverDB;

        public OrderService(ServerContext context)
        {
            serverDB = context;
        }

        //添加订单
        public Order AddOrderService(Order order)
        {
            try
            {
                order.OrderState = "等待司机接单";
                serverDB.Orders.Add(order);
                serverDB.SaveChanges();
            }catch(Exception e)
            {
                return null;
            }
            return order;
        }

        //司机获取订单
        public List<Order> GetOrderService(Driver driver)
        {
            var orders = serverDB.Orders
                .Where(op => op.ServiceType == driver.ServiceType&&op.OrderState == "等待司机接单")
                .ToList<Order>();
            if (orders.Count == 0)
                return null;
            foreach (Order order in orders)
                order.Customer = serverDB.Customers.FirstOrDefault(op => op.Id == order.CustomerId);
            return orders;
        }

        //司机接单
        public Order AcceptOrderService(Order order)
        {
            var order1 = serverDB.Orders.FirstOrDefault(op => op.Id == order.Id);
            if (order1.OrderState != "等待司机接单")
                return null;
            try
            {
                order1.DriverId = order.DriverId;
                order1.OrderState = "司机已接单，正在前往出发点";
                serverDB.Entry(order1).State = EntityState.Modified;
                serverDB.SaveChanges();
            }catch(Exception e)
            {
                return null;
            }
            order1.Customer = serverDB.Customers.FirstOrDefault(op => op.Id == order1.CustomerId);
            return order1;
        }

        //司机到达出发地接客
        public Order ArriveStartPointService(Order order)
        {
            try
            {
                order.OrderState = "乘客已上车，正在前往目的地";
                serverDB.Entry(order).State = EntityState.Modified;
                serverDB.SaveChanges();
            }
            catch (Exception e)
            {
                return null;
            }
            return order;
        }

        //司机到达目的地
        public Order ArriveDestinationService(Order order)
        {
            if (order.OrderState != "乘客已上车，正在前往目的地")
                return null;
            try
            {
                order.OrderState = "已到达目的地，订单等待支付";
                serverDB.Entry(order).State = EntityState.Modified;
                serverDB.SaveChanges();
            }
            catch (Exception e)
            {
                return null;
            }
            return order;
        }

        //乘客获取当前订单信息
        public Order GetOrderInfoCusService(int id)
        {
            Order order1 = null;
            try
            {
                order1 = serverDB.Orders.FirstOrDefault(op => op.Id == id);
            }catch(Exception e)
            {
                return null;
            }
            return order1;
        }
    }
}
