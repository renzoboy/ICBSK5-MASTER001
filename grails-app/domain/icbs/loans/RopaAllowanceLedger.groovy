package icbs.loans
import icbs.loans.ROPA
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.loans.RopaCollateralDetails

class RopaAllowanceLedger {
    Date recordDate
    UserMaster recordBy
    ROPA ropa
    ConfigItemStatus status
    Double landDebit
    Double landCredit
    Double bldgDebit
    Double bldgCredit
    Double otherDebitAmt
    Double otherCreditAmt
    String particulars
    RopaCollateralDetails ropaCollateralDetails
    
    static constraints = {
        recordDate nullable:true
        recordBy nullable:true
        ropa nullable:true
        status nullable:true
        landDebit nullable:true
        landCredit nullable:true
        bldgDebit nullable:true
        bldgCredit nullable:true
        particulars nullable:true
        ropaCollateralDetails nullable:true
        otherDebitAmt nullable:true
        otherCreditAmt nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }

}