package icbs.tellering
import icbs.tellering.TxnFile
import java.sql.Timestamp
import icbs.admin.UserMaster

class TxnReversal {
    static belongsTo = [txnFile:TxnFile]
    String txnParticulars
    String txnReference
    Timestamp txnTimestamp
    UserMaster reversedBy
    static constraints = {
        txnParticulars nullable:true
        txnReference nullable:true
        txnTimestamp nullable:true
        reversedBy nullable:true
    }
    static mapping = {
	id sqlType:'int', generator:'increment'
    }
}
