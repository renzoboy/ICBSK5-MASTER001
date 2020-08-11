package icbs.gl
import icbs.cif.Customer
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.lov.ConfigItemStatus

class AccountsReceivable {
    Customer customer
    Branch branch
    Currency currency
    String glContra
    Date bookingDate
    Date arCreatedDate
    String receivableName
    String description
    String reference
    Double balance
    Double requiredValuationReserves
    UserMaster user
    ConfigItemStatus status
    Date maturityDate
    Double requiredAllowance
    String acctNo
    
    static constraints = {
        acctNo nullable: true  
        customer nullable: true  
        branch nullable:true
        currency nullable:true
        glContra nullable:true
        bookingDate nullable:true
        description nullable:true
        balance min:0D, scale:2, nullable:true
        requiredValuationReserves min:0D, scale:2, nullable:true
        user nullable:true
        status nullable:true
        receivableName nullable:true
        reference nullable:true
        maturityDate nullable:true
        requiredAllowance min:0D, scale:2, nullable:true
        arCreatedDate nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    }      
}
