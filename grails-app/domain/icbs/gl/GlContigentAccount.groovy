package icbs.gl

import icbs.admin.Branch
import icbs.lov.ContigentAccount
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.loans.Loan

class GlContigentAccount {
    
    
    Loan loan
    String titleNo
    Integer nominalValue
    String currentCustodian
    Double registeredMortgage
    String remarks
    Date timestamp
    Date txnDate
    String particulars
    String reference
    Double debitAmt
    Double creditAmt
    ContigentAccount contigent
    UserMaster createdByUser
    Branch branch
    String accountNo
    ConfigItemStatus status
    
    static constraints = {
         txnDate nullable: true
         particulars nullable: true
         reference nullable: false
         debitAmt nullable: true
         creditAmt nullable: true
         contigent nullable: true
         createdByUser nullable: true
         branch nullable: true
         status nullable: true
         loan nullable: true
         titleNo nullable: true
         nominalValue nullable: true
         currentCustodian nullable: true
         registeredMortgage nullable: true
         remarks nullable: true
         timestamp nullable: true
         accountNo nullable: true
    }
    static mapping = {
    	 id sqlType: "int", generator: "increment"
         
    }

}
