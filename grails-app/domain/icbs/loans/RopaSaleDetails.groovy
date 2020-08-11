package icbs.loans
import icbs.tellering.TxnFile
import icbs.lov.LoanCollateralStatus
import icbs.admin.Branch
import icbs.admin.UserMaster

class RopaSaleDetails {
    String scrAccountNo
    String scrAccountName
    ROPA ropa
    Loan loan
    LoanApplication loanApplication
    Collateral collateral
    RopaCollateralDetails ropaCollateralDetails
    Double saleAmount //Selling Price
    Double downpayment
    Double accumulatedDepreciation // = accDepbldg + accDepOthers
    Double grossReceiptsTax
    Double commission
    Double scrDiscount
    Double difference // not used
    Double scrAmount
    String reference
    String particulars
    Double incomeAmount
    
    Double ropaLandAmt
    Double ropaBldgAmt
    Double ropaOtherAmt
    Double accDepBldg
    Double accDepOther
    
    Branch ropaBranch
    Branch processBranch
    
    TxnFile txnFile
    String ropaIncomeContra
    String ropaContra
    LoanCollateralStatus status
    UserMaster agent
    
    static constraints = {
        scrAccountNo nullable:true
        scrAccountName nullable:true
        ropaLandAmt nullable:true
        ropaBldgAmt nullable:true
        ropaOtherAmt nullable:true
        accDepBldg nullable:true
        accDepOther nullable:true
        ropaBranch nullable:true
        processBranch nullable:true
        //===========
        ropa nullable:true
        loanApplication nullable:true
        loan nullable:true
        collateral nullable:true
        ropaCollateralDetails nullable:true
        saleAmount nullable:true //Selling Price
        downpayment nullable:true
        accumulatedDepreciation nullable:true
        grossReceiptsTax nullable:true
        commission nullable:true
        scrDiscount nullable:true
        difference nullable:true
        scrAmount nullable:true
        reference nullable:true
        particulars nullable:true
        incomeAmount nullable:true
        txnFile nullable:true
        ropaIncomeContra nullable:true
        ropaContra nullable:true
        status nullable:true
        agent nullable:true
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }    
    def beforeInsert(){

        if (!this.scrAccountNo){
            if (this.loan){
                this.scrAccountNo = this.loan.accountNo
                this.scrAccountName = this.loan.customer.displayName
            }
        }
        return true
    }
}
