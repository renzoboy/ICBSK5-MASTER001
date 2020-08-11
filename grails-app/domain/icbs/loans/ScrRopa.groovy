package icbs.loans
import icbs.loans.ROPA

class ScrRopa {
    Loan loan
    ROPA ropa
    String remarks
    
    static constraints = {
        
        loan nullable:true
        ropa nullable:true
        remarks nullable:true
    }
}
