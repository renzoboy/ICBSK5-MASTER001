package icbs.loans
import icbs.loans.Loan
import icbs.lov.ConfigItemStatus
import icbs.admin.UserMaster
import icbs.admin.Branch
class LoanRestructureHist {
    
    Loan loan
    Date restructuredDate
    Double amount
    ConfigItemStatus status
    UserMaster restructuredBy
    Branch branch
    
    static constraints = {
        loan nullable:true
        restructuredDate nullable:true
        amount nullable:true
        status nullable:true
        restructuredBy nullable:true
        branch nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
