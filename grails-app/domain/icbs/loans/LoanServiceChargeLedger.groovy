package icbs.loans
import icbs.tellering.TxnFile

class LoanServiceChargeLedger {
    Loan loan
    LoanLossProvisionDetail loanProvision
    Date refDate
    String reference
    String particulars
    Double debitAmt
    Double creditAmt
    Double serviceChargeBalance
    TxnFile txnFile
    
    static constraints = {
        loan nullable:true
        loanProvision nullable:true
        refDate nullable:true
        reference nullable:true
        particulars nullable:true
        debitAmt nullable:true, scale:2
        creditAmt nullable:true, scale:2
        serviceChargeBalance nullable:true, scale:2
        txnFile nullable:true
    }
}

