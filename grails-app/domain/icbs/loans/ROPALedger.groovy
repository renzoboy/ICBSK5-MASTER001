package icbs.loans

import icbs.tellering.TxnFile

class ROPALedger {
    ROPA ropa
    Date txnDate
    Date valueDate
    String reference
    String particulars
    Double debitAmt
    Double creditAmt
    Double balanceAmt
    
    Double ropaLandAmt
    Double ropaBldgAmt
    Double ropaOtherAmt
    
    TxnFile txnFile
    
    static constraints = {
        ropa nullable:true
        txnDate nullable:true
        valueDate nullable:true
        reference nullable:true
        particulars nullable:true
        debitAmt min:0D, scale:2
        creditAmt min:0D, scale:2
        balanceAmt min:0D, scale:2
        
        ropaLandAmt nullable:true 
        ropaBldgAmt nullable:true 
        ropaOtherAmt nullable:true 
        txnFile nullable:true 
    }
    static mapping = {
      id sqlType: "int", generator: "increment"
    }    
}
