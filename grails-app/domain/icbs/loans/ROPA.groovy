package icbs.loans
import icbs.cif.Customer
import icbs.admin.UserMaster
import icbs.admin.Branch
import icbs.admin.Currency

class ROPA {
    Branch branch
    Customer acquiredFrom
    Currency currency
    Loan loan
    String loanAcctNo
    String customerDisplayName
    Date ropaDate
    
    String glContraLitigationExp
    String glContraRopa
    String glContraBldg
    String ropaIncome
    String otherAccumlated
    String otherGl
    
    UserMaster createdBy
    Date dateCreated // hindi ito gagamitin ang lagaing nakukuha nito is machine system date
    Date runDateCreated // ito yung ginagamit to get yung branch run date
    //Collateral collateral
    //Double loanBalance
    //Double ropaBalance
    //Double ropaLandBalance
    //Double ropaBldgBalance
    //Double costsCapitalized
    //Double provisionAmt
    //Currency currency
    //Double provisionRate
    //Double allocatedBookValueLand
    //Double allocatedBookValueBuilding
    //Double accumulatedDepreciationBuilding
     String accumulatedDepreciation
    //Double allowanceBuilding
    
    
    //Double otherAccumulatedAmt
    //Double otherGlAmt
    
    
    static constraints = {
        branch nullable:true
        currency nullable:true
        acquiredFrom nullable:true
        loan nullable:true
        loanAcctNo nullable:true
        customerDisplayName nullable:true
        ropaDate nullable:true
        
        glContraLitigationExp nullable:true
        glContraRopa nullable:true
        glContraBldg nullable:true
        ropaIncome nullable:true
        otherAccumlated nullable:true
        otherGl nullable:true
        
        createdBy nullable:true
        dateCreated nullable:true  
        runDateCreated nullable:true
        accumulatedDepreciation nullable:true
        
              
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
}
