package icbs.loans
import icbs.lov.LoanCollateralStatus
import icbs.admin.UserMaster

class RopaCollateralDetails {
        ROPA ropa
        Loan loan
        Collateral collateral
        Date refDate
        Double ropaLandAmt
        Double ropaBldgAmt
        Double ropaVehicleAmt
        Double ropaOtherAmt
        Double buildingAccDepreciation
        Double vehicleAccDepreciation
        Double otherAccDepreciation
        Double allowanceProbLoss
        Double allowanceProbLossBldg
        Double allowanceProbLossOtherProp
        LoanCollateralStatus status
        String formerTitle
        String kindOfLand
        Double landArea
        String location
        
        Date forClosureDate
        Date certificateDate
        Date certificateRegistrationDate
        Date notarizationOfDacionDate
        Date cosExpiryDateOfRedemption
        Date consolidatedDate
        String consolidatedTitleNumber
        Double fireInsuranceAmt
        String fireInsurancePolicyNo
        Date fireInsuranceStartDate
        Date fireInsuranceEndDate
        Date latestRatrDate
        UserMaster appraisedBy
    
    
        //Date issuancefCosDate
        String newTct
        Double landAppraisal
        Double buildingAppraisal
        Double otherAppraisal
        Date appraisalDate
        Double provisionForFireInsurance
        
    
    static constraints = {
        ropa nullable:true
        loan nullable:true
        collateral nullable:true
        refDate nullable:true
        ropaLandAmt nullable:true
        ropaBldgAmt nullable:true
        ropaVehicleAmt nullable:true
        ropaOtherAmt nullable:true
        buildingAccDepreciation nullable:true
        vehicleAccDepreciation nullable:true
        otherAccDepreciation nullable:true
        status nullable:true
        formerTitle nullable:true
        kindOfLand nullable:true
        landArea nullable:true
        location nullable:true
        
        forClosureDate nullable:true
        certificateDate nullable:true
        certificateRegistrationDate nullable:true
        notarizationOfDacionDate nullable:true
        cosExpiryDateOfRedemption nullable:true
        consolidatedDate nullable:true
        consolidatedTitleNumber nullable:true
        fireInsuranceAmt nullable:true
        fireInsurancePolicyNo nullable:true
        fireInsuranceStartDate nullable:true
        fireInsuranceEndDate nullable:true
        latestRatrDate nullable:true
        appraisedBy nullable:true
         
    
        //issuancefCosDate nullable:true
        newTct nullable:true
        landAppraisal nullable:true
        buildingAppraisal nullable:true
        otherAppraisal nullable:true
        appraisalDate nullable:true
        provisionForFireInsurance nullable:true
        allowanceProbLoss nullable:true
        allowanceProbLossBldg nullable:true
        allowanceProbLossOtherProp nullable:true
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }  
    def beforeInsert(){
	// determine user rights first
	if (!this.ropaLandAmt) {
            this.ropaLandAmt = 0.00D
        }
	if (!this.ropaBldgAmt) {
            this.ropaBldgAmt = 0.00D
        }
	if (!this.ropaVehicleAmt) {
           this.ropaVehicleAmt = 0.00D 
        }
	if (!this.ropaOtherAmt) {
            this.ropaOtherAmt = 0.00D
        }
	if (!this.buildingAccDepreciation) {
            this.buildingAccDepreciation = 0.00D
        }    
        if (!this.vehicleAccDepreciation) {
            this.vehicleAccDepreciation = 0.00D
        }  
        if (!this.otherAccDepreciation) {
            this.otherAccDepreciation = 0.00D
        }  
        if (!this.landAppraisal) {
            this.landAppraisal = 0.00D
        }
        if (!this.buildingAppraisal) {
            this.buildingAppraisal = 0.00D
        }
        if (!this.otherAppraisal) {
            this.otherAppraisal = 0.00D
        }
        if (!this.allowanceProbLoss){
            this.allowanceProbLoss = 0.00D
        }
        if (!this.allowanceProbLossBldg){
            this.allowanceProbLossBldg = 0.00D
        }
        if (!this.allowanceProbLossOtherProp){
            this.allowanceProbLossOtherProp = 0.00D
        }
        return true
    }

}
