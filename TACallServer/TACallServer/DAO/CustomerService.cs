using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TACallServer.Models;

namespace TACallServer.DAO
{
    public class CustomerService
    {
        private readonly ServerContext serverDB;

        public CustomerService(ServerContext context)
        {
            serverDB = context;
        }

        //用户登录
        public Customer LoginService(Customer customer)
        {
            var cus = serverDB.Customers.FirstOrDefault(op => op.Id == customer.Id && op.Password == customer.Password);
            return cus;
        }

        //用户注册
        public Customer RegisterService(Customer customer)
        {
            try
            {
                serverDB.Customers.Add(customer);
                serverDB.SaveChanges();
            }catch(Exception e)
            {
                return null;
            }
            return customer;
        }

        //修改个人信息
        public Customer SetAccountService (Customer customer)
        {
            try
            {
                serverDB.Entry(customer).State = EntityState.Modified;
                serverDB.SaveChanges();
            }catch(Exception e)
            {
                return null;
            }
            return customer;
        }
    }
}
