package icbs.tellering

import icbs.lov.TxnType
import icbs.admin.Currency
import icbs.cif.Customer
import icbs.admin.ForexRate
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus

class TxnForex {

    Currency currencyReceived
    Currency currencyPayout
    Double exchangeRate
    ForexRate exchangeRateRef
    Double receivedAmt
    Double paidOutAmt
    String txnParticulars
    Customer customer
    UserMaster user
    Double chargesAmt
    Double netAmtPaidOut
    ConfigItemStatus status
    Date txnDate
    TxnFile txnFileReceived
    TxnFile txnFilePaid
    TxnFile txnFileCharges
    
    static constraints = {
        currencyReceived nullable:true
        currencyPayout nullable:true
        exchangeRate nullable:true
        exchangeRateRef nullable:true
        receivedAmt nullable:true
        paidOutAmt nullable:true
        txnParticulars nullable:true
        customer nullable:true
        user nullable:true
        chargesAmt nullable:true
        netAmtPaidOut nullable:true
        status nullable:true
        txnDate nullable:true
        txnFileReceived nullable:true
        txnFilePaid nullable:true
        txnFileCharges nullable:true
    }
    
    static mapping = {
        id sqlType: 'int', generator: 'increment'
    }
}
