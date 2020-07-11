using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace TACallServer.Models
{
    public class ServerContext: DbContext
    {
        public ServerContext(DbContextOptions<ServerContext> options)
            : base(options)
        {
            this.Database.EnsureCreated();
        }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Driver> Drivers { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Car> Cars { get; set; }
        public DbSet<Purse> Purses { get; set; }
        public DbSet<Ticket> Tickets { get; set; }
    }
}
