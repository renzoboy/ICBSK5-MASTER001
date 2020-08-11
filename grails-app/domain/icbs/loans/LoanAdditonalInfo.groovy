package icbs.loans
import icbs.loans.Loan
import icbs.cif.Customer

class LoanAdditonalInfo {
    
    String accountNo 
    String customerName
    String address
    Date dateGranted
    Date maturityDate
    Double amountGranted
    Double accountBalance
    Double loanDiscountInterest
    Double serviceCharge
    Double otherDeferredCredits
    Date cutoffDate
    Double specificAllowance

    
    
    static constraints = {
        
     accountNo nullable:false
     customerName nullable:false
     address nullable:false
     dateGranted nullable:false
     maturityDate nullable:false
     amountGranted nullable:false
     accountBalance nullable:false
     loanDiscountInterest nullable:false
     serviceCharge nullable:false 
     otherDeferredCredits nullable:false
     cutoffDate nullable:false
     specificAllowance nullable:false
    }
    
    static mapping = {
        
        version false;
        id generator: 'identity',
        params: [table: 'LoanAdditonalInfo', column: 'id']
    }
    
}
