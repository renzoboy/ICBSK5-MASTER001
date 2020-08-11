package icbs.cif
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus


class Infobase {
    static belongsTo = [customer:Customer]
    String infoMessage
    Date refDate
    UserMaster user
    ConfigItemStatus status
    
    static constraints = {
        infoMessage nullable:false
        refDate nullable:false
        customer nullable:false
        user nullable:false
        status nullable:false
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }    
}
