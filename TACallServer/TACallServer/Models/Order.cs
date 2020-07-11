using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Order
    {
        public int Id { get; set; }
        public int CustomerId { get; set; }
        public Customer Customer { get; set; }
        public int DriverId { get; set; }
        [NotMapped]
        public Driver Driver { get; set; }
        public string OrderTime { get; set; }
        public double Price { get; set; }
        public string Destination { get; set; }
        public string StartPoint { get; set; }
        public string OrderState { get; set; }
        public string ServiceType { get; set; }
    }
}
