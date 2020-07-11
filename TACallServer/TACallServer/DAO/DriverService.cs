using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TACallServer.Models;
using Microsoft.EntityFrameworkCore;

namespace TACallServer.DAO
{
    public class DriverService
    {
        private readonly ServerContext serverDB;

        public DriverService(ServerContext context)
        {
            serverDB = context;
        }

        //司机登录
        public Driver LoginService(Driver driver)
        {
            var dri = serverDB.Drivers.FirstOrDefault(op => op.Id == driver.Id && op.Password == driver.Password);
            return dri;
        }

        //司机注册
        public Driver RegisterService(Driver driver)
        {
            try
            {
                serverDB.Drivers.Add(driver);
                serverDB.SaveChanges();
            }
            catch (Exception e)
            {
                return null;
            }
            return driver;
        }

        //修改个人信息
        public Driver SetAccountService(Driver driver)
        {
            try
            {
                serverDB.Entry(driver).State = EntityState.Modified;
                serverDB.SaveChanges();
            }
            catch (Exception e)
            {
                return null;
            }
            return driver;
        }
    }
}
