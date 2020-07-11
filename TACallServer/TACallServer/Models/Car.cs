using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Car
    {
        public int Id { get; set; }
        public string Color { get; set; }
        public string Brand { get; set; }
        public string LicensePlateNumber { get; set; }
        public int DriverId { get; set; }
        [NotMapped]
        public Driver Driver { get; set; }
    }
}
