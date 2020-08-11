package icbs.tellering

import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.admin.Currency

class TxnCashCheckBlotter {

    Double cashInAmt
    Double cashOutAmt
    Double checkInAmt
    Double checkOutAmt
    Branch branch
    String txnParticulars
    static belongsTo=[user:UserMaster];
    Currency currency
    TxnFile txnFile
    
    static constraints = {
        cashInAmt nullable:true, min:0d, scale:2
        cashOutAmt nullable:true, min:0d, scale:2
        checkInAmt nullable:true, min:0d, scale:2
        checkOutAmt nullable:true, min:0d, scale:2
        branch nullable:true
        txnParticulars nullable:true
        user nullable:true
        currency nullable:true
        txnFile nullable:true
    }
    
    static mapping = {
        id sqlType: 'int', generator: 'increment'
        txnParticulars sqlType: 'varchar'
    }
    
    def beforeInsert(){
         //blank txnTemplate
        if(!this.cashInAmt){
            this.cashInAmt = 0.00D
        }
        if(!this.cashOutAmt){
            this.cashOutAmt = 0.00D
        }    
        if(!this.checkInAmt){
            this.checkInAmt = 0.00D
        }  
        if(!this.checkOutAmt){
            this.checkOutAmt = 0.00D
        }        
        return true
    }     
}
