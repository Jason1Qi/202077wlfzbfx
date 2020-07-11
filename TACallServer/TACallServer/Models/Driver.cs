using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Driver
    {
        public int Id { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string ServiceType { get; set; }
        public string PhoneNumber { get; set; }
        public string Name { get; set; }
        public Car Car { get; set; }
    }
}
