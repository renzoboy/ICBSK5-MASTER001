package icbs.loans


class LoanEIRSchedule {
	Double transferAmount
	//boolean transferStatus
	Date transferDate
	Double uidAmount
	Double serviceChargeAmount	

    static constraints = {
		transferAmount nullable:true, scale:2
		transferDate nullable:true		
		uidAmount nullable:true, scale:2
		serviceChargeAmount nullable:true		
    }

    static mapping = {
		id sqlType: "int", generator: "increment"	
	}
}