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
    public class DriverController : ControllerBase
    {
        private DriverService driverService;
        public DriverController(ServerContext serverContext)
        {
            driverService = new DriverService(serverContext);
        }

        //注册
        [HttpPost("register")]
        public ActionResult<Driver> Register(Driver driver)
        {
            return driverService.RegisterService(driver);
        }

        //登录
        [HttpPost("login")]
        public ActionResult<Driver> Login(Driver driver)
        {
            return driverService.LoginService(driver);
        }

        //修改个人信息
        [HttpPut("setaccount")]
        public ActionResult<Driver> SetAccount(Driver driver)
        {
            return driverService.SetAccountService(driver);
        }
    }
}