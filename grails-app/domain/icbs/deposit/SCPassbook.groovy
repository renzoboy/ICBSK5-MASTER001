package icbs.deposit

import icbs.admin.UserMaster
import icbs.lov.SCPassbookStatus

class SCPassbook {
    static belongsTo = [docInventory:DocInventory] 
    IssuePassbook issuePassbook
    Long passbookNo
    String remarks
    SCPassbookStatus status
    static constraints = {
        issuePassbook nullable:true
        passbookNo nullable:false,unique:true
        status nullable:true
        remarks maxSize:255,nullable:true
    }
    static mapping={
        id sqlType: "int", generator: "increment"
    }
    def beforeInsert(){
        this.status =SCPassbookStatus.get(1)
    }
    def beforeUpdate(){
    }
}
