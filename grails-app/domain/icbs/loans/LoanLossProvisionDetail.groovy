package icbs.loans

class LoanLossProvisionDetail {
    
    Loan loan
    Double uidBalance
    Double totalProvision
    Double otherDeferredCredit
    Double loanServiceCharge
    String remarks
    
    static constraints = {
        loan nullable:true
        uidBalance nullable:true, scale:2
        totalProvision nullable:true, scale:2
        otherDeferredCredit nullable:true, scale:2
        loanServiceCharge nullable:true, scale:2
        remarks nullable:true        
    }
    
    static mapping = {
	id sqlType: "int", generator: "increment"
    }
    
    def beforeInsert(){
        if (!this.uidBalance) {
            this.uidBalance = 0.00D
        } 
        if (!this.totalProvision) {
            this.totalProvision = 0.00D
        } 
        if (!this.otherDeferredCredit){
            this.otherDeferredCredit = 0.00D
        }
        if (!this.loanServiceCharge){
            this.loanServiceCharge = 0.00D
        }
    }
    
}

