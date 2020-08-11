package icbs.loans
import icbs.loans.Loan
import icbs.admin.TxnTemplate
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.admin.Branch
import icbs.tellering.TxnFile
import icbs.lov.ConfigItemStatus
import icbs.lov.LoanAcctStatus
import java.sql.Timestamp
import icbs.loans.LoanWriteOffCollectors
import icbs.lov.WriteOffCollectionType

class LoanWriteOffCollectionHist {
    
    TxnFile txnFile
    Branch branch
    Currency currency
    Loan loan
    String txnDescription
    UserMaster transactBy
    Timestamp txnTimestamp
    ConfigItemStatus status
    Double txnAmount
    UserMaster collectedBy
    Date txnDate
    WriteOffCollectionType writeOffCollectionType
    static constraints = {
        txnFile nullable:true
        branch nullable:true
        currency nullable:true
        loan nullable:true
        txnDescription nullable:true
        transactBy nullable:true
        txnTimestamp nullable:true
        status nullable:true
        txnAmount nullable:true
        collectedBy nullable:true
        txnDate nullable:true
        writeOffCollectionType nullable:true
    }
    static mapping = {
        id sqlType: 'int', generator: 'increment'
        
    }
    
}
