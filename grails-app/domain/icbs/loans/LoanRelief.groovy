package icbs.loans
import icbs.admin.UserMaster

class LoanRelief {
    Loan loan
    Boolean loanReliefStatus
    Date reliefDate
    Double loanAmount
    Date reliefRemovalDate
    String particulars
    UserMaster updatedBy
    UserMaster removedBy
    
    static constraints = {
        loan nullable:true
        loanReliefStatus nullable:true
        loanAmount nullable:true, min:0.00D
        reliefDate nullable:true
        reliefRemovalDate nullable:true
        particulars nullable:true
        updatedBy nullable:true
        removedBy nullable:true    
    }
    
    static mapping = {
    	id sqlType: "int", generator: "increment"
    } 
}
