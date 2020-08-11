package icbs.loans
import icbs.tellering.TxnFile

class LoanUidLedger {
    Loan loan
    LoanLossProvisionDetail loanProvision
    Date refDate
    String reference
    String particulars
    Double debitAmt
    Double creditAmt
    Double uidBalance
    TxnFile txnFile
    
    static constraints = {
        loan nullable:true
        loanProvision nullable:true
        refDate nullable:true
        reference nullable:true
        particulars nullable:true
        debitAmt nullable:true, scale:2
        creditAmt nullable:true, scale:2
        uidBalance nullable:true, scale:2
        txnFile nullable:true
    }
    
    static mapping = {
	id sqlType: "int", generator: "increment"
    }
}
