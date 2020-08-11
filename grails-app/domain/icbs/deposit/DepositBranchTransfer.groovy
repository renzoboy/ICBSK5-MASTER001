package icbs.deposit
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.tellering.TxnFile

class DepositBranchTransfer {
    Deposit deposit
    Branch newBranch
    Branch oldBranch
    TxnFile depositDr
    TxnFile depositCr
    Date transferDate
    String particulars
    String reference
    UserMaster user
    Branch userBranch
    
    static constraints = {
        deposit nullable:true
        newBranch nullable:true
        oldBranch nullable:true
        depositDr nullable:true
        depositCr nullable:true
        transferDate nullable:true
        particulars nullable:true
        reference nullable:true
        user nullable:true
        userBranch nullable:true
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
