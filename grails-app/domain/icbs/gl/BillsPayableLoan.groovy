package icbs.gl

import icbs.loans.Loan
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus

class BillsPayableLoan {
    BillsPayable billsPayable
    Loan loan
    Date linkDate
    UserMaster user
    ConfigItemStatus status
    
    static constraints = {
        billsPayable nullable:true
        loan nullable:true
        linkDate nullable:true
        user nullable:true
        status nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    }     
}
