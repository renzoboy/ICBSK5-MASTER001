package icbs.gl
import icbs.admin.Branch

class InterBranchPointer {
    Branch branch
    String debitPointer
    String creditPointer
    
    static constraints = {
        branch nullable:true
        debitPointer nullable:true
        creditPointer nullable:true  
    }
    
    static mapping = {
    	id sqlType:'int', generator:'increment'
    }    
}
