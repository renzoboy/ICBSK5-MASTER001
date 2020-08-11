package icbs.loans

class LoanRediscountingStatus {
    String code
    String description
    String shortDescription
    boolean status

    static constraints = {
    	code nullable:true
    	description nullable:true
        shortDescription nullable:true
    }

    static mapping = {
    	id sqlType: "int", generator: "increment"
    }

    String toString() {
        return description
    }

    String getCodeDescription() {
        "${code} - ${description}"
    }
}
