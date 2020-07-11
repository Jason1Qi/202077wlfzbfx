using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using TACallServer.DAO;
using TACallServer.Models;


namespace TACallServer.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrderController : ControllerBase
    {
        private OrderService orderService;
        public OrderController(ServerContext serverContext)
        {
           orderService = new OrderService(serverContext);
        }

        //乘客下单
        [HttpPost("addorder")]
        public ActionResult<Order> AddOrder(Order order)
        {
            return orderService.AddOrderService(order);
        }

        //司机获取订单
        [HttpPost("getorder")]
        public ActionResult<List<Order>> GetOrder(Driver driver)
        {
            return orderService.GetOrderService(driver);
        }

        //司机接单
        [HttpPut("acceptorder")]
        public ActionResult<Order> AcceptOrder(Order order)
        {
            return orderService.AcceptOrderService(order);
        }

        //司机到达出发地接到乘客
        [HttpPut("arrivestartpoint")]
        public ActionResult<Order> ArriveStartPoint(Order order)
        {
            return orderService.ArriveStartPointService(order);
        }

        //到达目的地
        [HttpPut("arrivedestination")]
        public ActionResult<Order> ArriveDestination(Order order)
        {
            return orderService.ArriveDestinationService(order);
        }

        //乘客获取当前订单信息
        [HttpGet("getorderinfocus/{orderid}")]
        public ActionResult<Order> GetOrderInfoCus(int orderid)
        {
            return orderService.GetOrderInfoCusService(orderid);
        }
    }
   
}