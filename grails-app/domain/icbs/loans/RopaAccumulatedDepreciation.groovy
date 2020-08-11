package icbs.loans

import icbs.loans.ROPA
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.loans.RopaCollateralDetails
class RopaAccumulatedDepreciation {
    Date recordDate
    UserMaster recordBy
    ROPA ropa
    ConfigItemStatus status
    Double debitAmt
    Double creditAmt
    Double otherDebitAmt
    Double otherCreditAmt
    String reference
    String particulars
    RopaCollateralDetails ropaCollateralDetails
    static constraints = {
        recordDate nullable:true
        recordBy nullable:true
        ropa nullable:true
        status nullable:true
        debitAmt nullable:true
        creditAmt nullable:true
        reference nullable:true
        particulars nullable:true
        ropaCollateralDetails nullable:true
        otherDebitAmt nullable:true
        otherCreditAmt nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
