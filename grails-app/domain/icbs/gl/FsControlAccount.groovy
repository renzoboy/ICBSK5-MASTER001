package icbs.gl
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster
class FsControlAccount {
    
    String account
    String description
    ConfigItemStatus status
    UserMaster createdBy
    Date xCreatedDate
    
    static constraints = {
        account nullable:true
        description nullable:true
        status nullable:true
        createdBy nullable:true
        xCreatedDate nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    }
}