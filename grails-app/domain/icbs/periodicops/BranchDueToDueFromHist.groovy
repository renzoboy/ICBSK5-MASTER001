package icbs.periodicops

import icbs.lov.BranchRunStatus
import icbs.lov.BranchStatus
import icbs.lov.Lov
import icbs.gl.GlAccount
import icbs.admin.Branch

class BranchDueToDueFromHist {
    
    Branch branch
    String branchName
    GlAccount dueToGl
    GlAccount dueFromGl
    GlAccount yearEndClosingGl
    GlAccount iccContra
    
    static constraints = {
        branch nullable:true
        branchName nullable:true
        dueToGl nullable:true
        dueFromGl nullable:true
        yearEndClosingGl nullable:true
        iccContra nullable:true
    }
    static mapping = {
    	id sqlType:'int', generator:'increment'
    }
}
