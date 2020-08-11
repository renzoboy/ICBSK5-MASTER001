package icbs.admin
import icbs.gl.GlAccount

class UserMultiCurrencyCash {
    UserMaster user
    GlAccount cash
    Currency currency
    
    static constraints = {
        user nullable:true
        cash nullable:true
        currency nullable:true        
    }
    
    static mapping = {
    	id sqlType:'int', generator:'increment'
    }
    
}