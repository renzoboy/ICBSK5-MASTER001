package icbs.cif

import icbs.admin.UserMaster
import icbs.lov.Lov
import icbs.lov.ConfigItemStatus
import icbs.lov.MembershipType


class Membership {
    
    static hasMany=[
        membershipHistories:MembershipHistory
    ]
    static mappedBy=[currentMembership:"membership"]
    List membershipHistories = [].withLazyDefault {new MembershipHistory()}
    Date dateCreated
    Date membershipDate
    UserMaster createdBy
    String refferedBy
    Lov relationship
    ConfigItemStatus status
    MembershipType membershipType
    MembershipHistory currentMembership
    Customer customer

    static constraints = {
         customer nullable:false
         membershipDate nullable:true
         dateCreated nullable: true
         createdBy nullable: true
         refferedBy nullable: true
         relationship nullable: true
         status nullable: true
         membershipType nullable: true
         currentMembership nullable:true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
    
    def beforeInsert(){
        this.status = ConfigItemStatus.get(2)
    }
    
}
