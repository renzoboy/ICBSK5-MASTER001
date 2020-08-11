package icbs.gl
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.lov.ConfigItemStatus
import icbs.gl.HtmType
import icbs.lov.ResidentType
class AssetsHeldToMaturity {
    ResidentType residentType
    Branch branch
    Currency currency
    String htmType
    String htmDescription
    String reference
    Double amount
    HtmType htmTypeDesc
    Double interest
    Double maturityValue
    Double interestRate
    Double effectiveYield
    Date valueDate
    Date maturityDate
    String remarks
    String glCode
    Date createdDate
    UserMaster createdBy
    ConfigItemStatus status
    String htmAccrualDebitAcct
    String htmAccrualCredittAcct
    Double discountAmount
    String htmIssuer
    static constraints = {
        residentType nullable:true
        htmIssuer nullable:true
        htmTypeDesc nullable:true
        discountAmount nullable:true
        htmAccrualDebitAcct nullable:true
        htmAccrualCredittAcct nullable:true
        branch nullable:true
        currency nullable:true
        htmType nullable:true
        htmDescription nullable:true
        reference nullable:true
        amount nullable:true, mid:0D, scale:2
        interest nullable:true, mid:0D, scale:2
        maturityValue nullable:true, mid:0D, scale:2
        interestRate nullable:true, mid:0D, scale:5
        effectiveYield nullable:true, mid:0D, scale:5
        valueDate nullable:true
        maturityDate nullable:true
        remarks nullable:true
        glCode nullable:true
        createdDate nullable:true
        createdBy nullable:true
        status nullable:true
    }
    
    static mapping = {
      id sqlType: "int", generator: "increment"
    } 
}
