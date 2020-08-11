package icbs.tellering
import icbs.lov.SssPaymentCode
import icbs.lov.SssPaymentType
import icbs.lov.SssPayorType

class TxnSssCollection {

    TxnFile txnFile
    SssPaymentCode paymentCode
    SssPaymentType paymentType
    SssPayorType payorType
    String ssNumber
    String startingPeriod //yyyyMM
    String endingPeriod //yyyyMM
    Double ssAmountPaid
    Double ecAmountPaid
    
    static constraints = {
        txnFile nullable:true
        paymentCode nullable:true
        paymentType nullable:true
        payorType nullable:true
        ssNumber nullable:true
        startingPeriod nullable:true
        endingPeriod nullable:true
        ssAmountPaid min:0.00D, nullable:true
        ecAmountPaid min:0.00D, nullable:true      
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
