package icbs.loans
import icbs.lov.Commodity

class LoanGuaranteeDetail {

    Loan loan
    Commodity agfpCommodity
    Double agfpHectaresOrHeads
    Boolean agfpPcicInsured
    Boolean agfpArbBorrower   
    Double agfpGuaranteeRate
    Double agfpGuaranteeFee
    String agfpReferred
    String agfpRemarks
    
    String sbgfcMainOfficeAddress
    String sbgfcPosition
    Double sbgfcNetWorth
    String sbgfcNatureOfBusiness
    String sbgfcBusinessType
    String sbgfcStartOfBusinessOperation
    Double sbgfcAssetSize
    Integer sbgfcNumberOfEmployees
    Date sbgfcApprovalExiryDate
    String sbgfcTypeOfLoan
    String sbgfcPurposeOfLoan
    Double sbgfcOutstandingBalance
    Double sbgfcDsc
    Integer sbgfcInitialBrrTotalPoints
    Double sbgfcInitialBrrGrade
    Integer sbgfcBrrTotalPoints
    Double sbgfcBrrGrade
    String sbgfcTypeOfCollateral
    Double sbgfcMarketValue
    Double sbgfcLoanValue
    String sbgfcBusinessName
    
    Double hgcValueForEnrollment 
    Date hgcCoverageStartPeriod
    Date hgcCoverageEndPeriod
    Double hgcPremiumRate
    Double hgcPremiumDue
    String hgcTctNo
    String hgcLocation
    Double hgcAppraisedValue
    Double hgcLoanToValueRatio
    //new domain
    Double hgcValueOfNewReleaseForEnrollment
    Double hgcTotalAmountReleased
    Date hgcloanReleasedDate
    String hgcCogNoOfTheFirstReleased
    Date hgcAddCoverageStartPeriod
    Date hgcAddCoverageEndPeriod 
    Double hgcAddPremiumDue
    
    
    Boolean rediscounting
    String rediscountingAgent
    
    static constraints = {
        loan nullable:true
        agfpCommodity nullable:true
        agfpHectaresOrHeads nullable:true, scale:2, min:0.00D
        agfpPcicInsured nullable:true
        agfpArbBorrower nullable:true   
        agfpGuaranteeRate nullable:true, scale:5, min:0.00D
        agfpGuaranteeFee nullable:true, scale:2, min:0.00D
        agfpReferred nullable:true
        agfpRemarks nullable:true
    
        sbgfcMainOfficeAddress nullable:true
        sbgfcPosition nullable:true
        sbgfcNetWorth nullable:true, scale:2, min:0.00D
        sbgfcNatureOfBusiness nullable:true
        sbgfcBusinessType nullable:true
        sbgfcStartOfBusinessOperation nullable:true 
        sbgfcAssetSize nullable:true, scale:2, min:0.00D
        sbgfcNumberOfEmployees nullable:true, min:0
        sbgfcApprovalExiryDate nullable:true
        sbgfcTypeOfLoan nullable:true
        sbgfcPurposeOfLoan nullable:true
        sbgfcOutstandingBalance nullable:true, scale:2, min:0.00D
        sbgfcDsc nullable:true, scale:2, min:0.00D
        sbgfcInitialBrrTotalPoints nullable:true, min:0
        sbgfcInitialBrrGrade nullable:true, scale:2, min:0.00D
        sbgfcBrrTotalPoints nullable:true, min:0
        sbgfcBrrGrade nullable:true, scale:2, min:0.00D
        sbgfcTypeOfCollateral nullable:true
        sbgfcMarketValue nullable:true, scale:2, min:0.00D
        sbgfcLoanValue nullable:true, scale:2, min:0.00D
        sbgfcBusinessName nullable:true
    
        hgcValueForEnrollment nullable:true, scale:2, min:0.00D 
        hgcCoverageStartPeriod nullable:true
        hgcCoverageEndPeriod nullable:true
        hgcPremiumRate nullable:true, scale:5, min:0.00D
        hgcPremiumDue nullable:true, scale:2, min:0.00D
        hgcTctNo nullable:true
        hgcLocation nullable:true
        hgcAppraisedValue nullable:true, scale:2, min:0.00D
        hgcLoanToValueRatio nullable:true, scale:5
        hgcValueOfNewReleaseForEnrollment nullable:true, scale:2, min:0.00D
        hgcTotalAmountReleased nullable:true, scale:2, min:0.00D
        hgcloanReleasedDate nullable:true
        hgcCogNoOfTheFirstReleased nullable:true
        hgcAddPremiumDue nullable:true
        hgcAddCoverageStartPeriod nullable:true
        hgcAddCoverageEndPeriod nullable:true

    
        rediscounting nullable:true
        rediscountingAgent nullable:true
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    }
}
