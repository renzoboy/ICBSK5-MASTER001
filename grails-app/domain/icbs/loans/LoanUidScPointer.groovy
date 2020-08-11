package icbs.loans

import icbs.loans.LoanDeductionScheme
import icbs.lov.ConfigItemStatus
class LoanUidScPointer {

    String description
    LoanDeductionScheme loanDeductionScheme
    ConfigItemStatus status
    
    static constraints = {
        description nullable:true
        loanDeductionScheme nullable:true
        status nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    } 
}
