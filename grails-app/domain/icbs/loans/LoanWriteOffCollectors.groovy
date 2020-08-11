package icbs.loans

class LoanWriteOffCollectors {
    String name
    String address
    
    static constraints = {
        name nullable: true
        address nullable: true
    }
    static mapping = {
        id sqlType: 'int', generator: 'increment'
    }
    
}
