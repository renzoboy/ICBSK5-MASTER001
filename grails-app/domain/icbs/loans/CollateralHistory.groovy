package icbs.loans
import icbs.admin.UserMaster

class CollateralHistory {
    Collateral collateral
    Date    refDate
    String  description
    UserMaster user
    
    static constraints = {
        collateral nullable:true
        refDate nullable:true
        description nullable:true
        user nullable:true
    }
    
    static mapping = {
	id sqlType: "int", generator: "increment"
    }
}
