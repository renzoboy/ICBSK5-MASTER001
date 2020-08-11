package icbs.loans

import icbs.admin.UserMaster
import icbs.lov.LoanApplicationStatusNR
import icbs.lov.ConfigItemStatus

class CreditInvestigation {
	LoanApplication loanApplication
	String recommendation
	Date dateCreated
        Date ciCreatedDate
        Date folderReceivedByBranchDept
        Date folderTransToCau
        Date assignedToCi
        Date schedForCi
        Date performedCi
        Date assignedToAnalyst
        Date schedForAnalyst
        Date performedByAnalyst
        Date submitAnalystRep
        Date schedForCac
        Date actualCac
        Date schedCrecom
        Date actualCrecom
        //new fields 1/22/2019
        Date deadlineAssignedToCreCom
        Date dateSubByCreditInvestigator
        Date deadlineSubAnalystreport
        LoanApplicationStatusNR status
        Date reviewDateByManager
        // new field 05/18/2019
        ConfigItemStatus lnTrackingStatus
        Date approvalDate
        String ciName
        String analysName
        UserMaster ci
        UserMaster analyst
        //using in checklist values
        boolean formA1
        boolean formA2
        boolean formA3
        boolean formA4
        boolean formA5
        boolean formA6
        boolean formA7
        boolean formA8
        boolean formA9
        boolean formA10
        boolean formA11
        boolean formB1
        boolean formB2
        boolean formB3
        boolean formB4
        boolean formB5
        boolean formB6
        boolean formB7
        boolean formB8
        boolean formB9
        boolean formB10
        boolean formB11
        boolean formB12
        boolean formB13
        boolean formB14
        boolean formB15
        boolean formB16
        boolean formB17
        boolean formB18
        boolean formC1
        boolean formC2
        boolean formC3
        boolean formC4
        boolean formC5
        boolean formC6
        boolean formC7
        boolean formC8
        boolean formC9
        boolean formC10
        boolean formC11
        boolean formC12
        boolean formC13
        boolean formC14
        boolean formC15
        boolean formC16
        boolean formC17
        boolean formC18
        boolean formC19
        boolean formC20
        boolean formC21
        boolean formC22
        boolean formC23
        boolean formC24
        boolean formC25
        boolean formC26
        boolean formC27
        boolean formC28
        boolean formC29
        boolean formC30
        boolean formC31
        boolean formC32
        boolean formC33
        boolean formC34
        boolean formC35
    

    
    
    
    static hasMany = [attachments: LoanAttachment]

	static constraints = {
        lnTrackingStatus nullable:true            
        ciCreatedDate nullable:true    
	loanApplication nullable: false
        status nullable:true
    	recommendation nullable:true
        reviewDateByManager nullable:true
        dateCreated nullable:true
        folderReceivedByBranchDept nullable:true
        folderTransToCau nullable:true
        assignedToCi nullable:true
        deadlineAssignedToCreCom nullable:true
        schedForCi nullable:true
        performedCi nullable:true
        dateSubByCreditInvestigator nullable:true
        assignedToAnalyst nullable:true
        schedForAnalyst nullable:true
        performedByAnalyst nullable:true
        deadlineSubAnalystreport nullable:true
        submitAnalystRep nullable:true
        schedForCac nullable:true
        actualCac nullable:true
        schedCrecom nullable:true
        actualCrecom nullable:true
        approvalDate nullable:true

        ciName nullable:true
        analysName nullable:true
        ci nullable:true
        analyst nullable:true

        
        //using in checklist values
        formA1 nullable:true
        formA2 nullable:true
        formA3 nullable:true
        formA4 nullable:true
        formA5 nullable:true
        formA6 nullable:true
        formA7 nullable:true
        formA8 nullable:true
        formA9 nullable:true
        formA10 nullable:true
        formA11 nullable:true
        formB1 nullable:true
        formB2 nullable:true
        formB3 nullable:true
        formB4 nullable:true
        formB5 nullable:true
        formB6 nullable:true
        formB7 nullable:true
        formB8 nullable:true
        formB9 nullable:true
        formB10 nullable:true
        formB11 nullable:true
        formB12 nullable:true
        formB13 nullable:true
        formB14 nullable:true
        formB15 nullable:true
        formB16 nullable:true
        formB17 nullable:true
        formB18 nullable:true
        formC1 nullable:true
        formC2 nullable:true
        formC3 nullable:true
        formC4 nullable:true
        formC5 nullable:true
        formC6 nullable:true
        formC7 nullable:true
        formC8 nullable:true
        formC9 nullable:true
        formC10 nullable:true
        formC11 nullable:true
        formC12 nullable:true
        formC13 nullable:true
        formC14 nullable:true
        formC15 nullable:true
        formC16 nullable:true
        formC17 nullable:true
        formC18 nullable:true
        formC19 nullable:true
        formC20 nullable:true
        formC21 nullable:true
        formC22 nullable:true
        formC23 nullable:true
        formC24 nullable:true
        formC25 nullable:true
        formC26 nullable:true
        formC27 nullable:true
        formC28 nullable:true
        formC29 nullable:true
        formC30 nullable:true
        formC31 nullable:true
        formC32 nullable:true
        formC33 nullable:true
        formC34 nullable:true
        formC35 nullable:true 
    }
	static mapping = {
    	id sqlType: "int", generator: "increment"
    	loanApplication sqlType: "int"
    }

    def beforeValidate(){
        dateCreated = new Date()
    }
}