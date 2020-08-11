package icbs.loans

import icbs.admin.Branch
import icbs.lov.LoanRediscountingPartner
import icbs.loans.LoanRediscountingStatus
class LoanRediscounting {
    Loan loan
    Date dateGranted
    Date maturityDate
    String pnNo
    LoanRediscountingPartner loanRediscountingPartner
    LoanRediscountingStatus loanRediscountingStatus
    static constraints = {
        loan nullable:true
        dateGranted nullable:true
        maturityDate nullable:true
        pnNo nullable:true
        loanRediscountingStatus nullable:true
    }
}
