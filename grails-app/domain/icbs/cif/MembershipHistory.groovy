package icbs.cif

import icbs.admin.UserMaster
import icbs.lov.Lov
import icbs.lov.ConfigItemStatus
import icbs.lov.MembershipType

class MembershipHistory {

    Date membershipDate
    Date dateCreated
    UserMaster createdBy
    String refferedBy
    Lov relationship
    ConfigItemStatus status
    Membership member
    MembershipType membershipType

    static constraints = {
         membershipDate nullable: true
         dateCreated nullable: true
         createdBy nullable: true
         refferedBy nullable: true
         relationship nullable: true
         status nullable: true
         member nullable:true
         membershipType nullable: true
    }
    static mapping = {
        id sqlType: "int", generator: "increment"
    }

}
