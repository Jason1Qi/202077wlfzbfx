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
    public class CustomerController : ControllerBase
    {
        private CustomerService customerService;
        public CustomerController(ServerContext serverContext)
        {
            customerService = new CustomerService(serverContext);
        }

        //注册
        [HttpPost("register")]
        public ActionResult<Customer> Register(Customer customer)
        {
            return customerService.RegisterService(customer);
        }

        //登录
        [HttpPost("login")]
        public ActionResult<Customer> Login(Customer customer)
        {
            return customerService.LoginService(customer);
        }

        //修改个人信息
        [HttpPut("setaccount")]
        public ActionResult<Customer> SetAccount(Customer customer)
        {
            return customerService.SetAccountService(customer);
        }
    }
}