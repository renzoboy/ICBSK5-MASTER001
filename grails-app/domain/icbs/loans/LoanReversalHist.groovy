package icbs.loans
import icbs.tellering.TxnFile
import icbs.loans.Loan
class LoanReversalHist {
    
    TxnFile origTxnFile
    TxnFile reverseTxnFile
    Loan loan
    Boolean isReverse
    String reference
    String particulars
    static constraints = {
        
        origTxnFile nullable:true
        reverseTxnFile nullable:true
        loan nullable:true
        isReverse nullable:true
        reference nullable:true
        particulars nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
