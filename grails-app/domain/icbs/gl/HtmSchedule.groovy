package icbs.gl
import icbs.gl.AssetsHeldToMaturity
import icbs.lov.ConfigItemStatus

class HtmSchedule {
    
    AssetsHeldToMaturity assetsHeldToMaturity
    Date xhtmScheduleDate
    Double amount
    ConfigItemStatus status
    
    static constraints = {
        assetsHeldToMaturity nullable:true
        xhtmScheduleDate nullable:true
        amount nullable:true, scale:2
        status nullable:true
    }
    static mapping = {
      id sqlType: "int", generator: "increment"
    } 
}
