package icbs.deposit

class InwardClearingLoad {
    String acctNo
    Long chequeNo
    Double amt
    String brstn
    String trancd
    static constraints = {
        acctNo nullable: true
        chequeNo nullable: true
        amt nullable: true
        brstn nullable: true
        trancd nullable: true
    }
    static mapping = {
    	id sqlType: "int", generator: "increment"
        
    }
}
