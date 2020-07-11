using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace TACallServer.Models
{
    public class Ticket
    {
        public int Id { get; set; }
        public double Discount { get; set; }
        public int PurseId { get; set; }
        [JsonIgnore]
        [IgnoreDataMember]
        public Purse Purse { get; set; }
    }
}
