package icbs.loans
import icbs.tellering.TxnFile

class LoanAllowanceLedger {
    
    Loan loan
    LoanLossProvisionDetail loanProvision
    Date refDate
    String allowanceType
    // 1 - Addtional Allowance (credit)
    // 2 - Transfer Allowance (debit)
    
    String reference
    String particulars
    Double debitAmt
    Double creditAmt
    Double totalAllowance
    TxnFile txnFile
    
    static constraints = {
        loan nullable:true
        loanProvision nullable:true
        refDate nullable:true
        allowanceType nullable:true   
        reference nullable:true
        particulars nullable:true
        debitAmt nullable:true, scale:2
        creditAmt nullable:true, scale:2
        totalAllowance nullable:true, scale:2
        txnFile nullable:true
    }
    
}
