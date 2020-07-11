using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Purse
    {
        public int Id { get; set; }
        public double Account { get; set; }
        public int Integral { get; set; }
        public int CustomerId { get; set; }
        [JsonIgnore]
        [IgnoreDataMember]
        public Customer Customer { get; set; }
        public List<Ticket> Tickets { get; set; }
    }
}
