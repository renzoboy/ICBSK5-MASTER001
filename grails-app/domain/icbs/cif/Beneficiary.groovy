package icbs.cif

import icbs.lov.Lov
import icbs.lov.ConfigItemStatus

class Beneficiary {

    static belongsTo = [customer:Customer]
    
    String lastName
    String firstName
    String middleName
    Date birthDate
    String suffixName
    Lov customerRelationship
    ConfigItemStatus status
    
    static constraints = {
         customer nullable:false
         lastName nullable:true
         firstName nullable:true
         middleName nullable:true
         birthDate nullable:true
         suffixName nullable:true
         customerRelationship nullable:true
         status nullable:true
         
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
    boolean deleted
    static transients = ['deleted']
    
    def beforeInsert(){
        this.status = ConfigItemStatus.get(2)
    }
}
