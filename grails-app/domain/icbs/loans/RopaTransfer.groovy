package icbs.loans
import icbs.tellering.TxnFile
import icbs.loans.RopaCollateralDetails

class RopaTransfer {
        Loan loan
        RopaCollateralDetails ropaCollateralDetails
        ROPA ropa
        Double transferAmount
        Double marketValueLand
        Double marketValueBuilding
        Double marketValueOther
        
        Double ropaLandAmount
        Double ropaBuildingAmount
        Double otherGlAmount
        
        TxnFile txnFile
        

    static constraints = {
        loan nullable:true
        ropaCollateralDetails nullable:true
        ropa nullable:true
        transferAmount nullable:true
        marketValueLand nullable:true
        marketValueBuilding nullable:true
        marketValueOther nullable:true

        ropaLandAmount nullable:true
        ropaBuildingAmount nullable:true
        otherGlAmount nullable:true
        txnFile nullable:true
    }
    static mapping = {
        id sqlType:'int', generator: 'increment'
    }
}
