package icbs.cif
import icbs.lov.ConfigItemStatus
import icbs.lov.Lov
import icbs.lov.CustomerType
import icbs.lov.CustomerStatus
import icbs.lov.Gender
import icbs.admin.UserMaster
import icbs.cif.Customer
class CustomerToUserRelation {
 
    Customer customer
    UserMaster relateToUser
    Lov type
    ConfigItemStatus status
    
    static constraints = {
    customer nullable: true
    relateToUser nullable: true
    type nullable: true
    status nullable: true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
