package icbs.loans
import icbs.admin.UserMaster

class LoanRemark {
    Loan loan
    String remarks
    Date remarkDate
    UserMaster createdBy
    UserMaster lastUpdateBy
    Date lastUpdateDate
    
    static constraints = {
        loan nullable:true
        remarks nullable:true
        remarkDate nullable:true
        createdBy nullable:true
        lastUpdateBy nullable:true
        lastUpdateDate nullable:true
    }
    
    static mapping = {
	id sqlType: "int", generator: "increment"
    }
}
