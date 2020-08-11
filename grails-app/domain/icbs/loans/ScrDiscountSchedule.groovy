package icbs.loans

import icbs.loans.Loan
import icbs.cif.Customer
import icbs.admin.UserMaster
import icbs.admin.Branch
import icbs.admin.Currency
import icbs.lov.ConfigItemStatus

class ScrDiscountSchedule {
    
    Loan loan
    Date scrdateCreated
    Branch branch
    Double debitAmt
    Double creditAmt
    Date scheduleDate
    String reference
    String particulars
    UserMaster createdBy
    ConfigItemStatus status
    
    static constraints = {
        loan nullable:true
        scrdateCreated nullable:true
        branch nullable:true
        debitAmt nullable:true
        creditAmt nullable:true
        scheduleDate nullable:true
        reference nullable:true
        particulars nullable:true
        createdBy nullable:true
        status nullable:true
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
