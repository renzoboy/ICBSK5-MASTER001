package icbs.gl

class AllowanceClassification {
    Integer noOfDaysFrom
    Integer noOfDaysTo
    String allowanceClassDescription
    Double acl
    
    static constraints = {
        noOfDaysFrom nullable:true
        noOfDaysTo nullable:true
        allowanceClassDescription nullable:true
        acl nullable:true
    }
    static mapping = {
      id sqlType: "int", generator: "increment"
    }   
}
