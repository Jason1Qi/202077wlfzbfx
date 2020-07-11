using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Customer
    {
        public int Id { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string Address { get; set; }
        public string PhoneNumber { get; set; }
        [JsonIgnore]
        [IgnoreDataMember]
        public List<Order> Orders { get; set; }
        public Purse Purse { get; set; }
    }
}
