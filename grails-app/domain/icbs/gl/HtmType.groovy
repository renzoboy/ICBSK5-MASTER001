package icbs.gl

class HtmType {
    
    String code
    String description
    boolean status

    static constraints = {
        code nullable:true
        description nullable:true
    }

    static mapping = {
        id sqlType:'smallint'
    }

    String toString() {
        return description
    }

    String getCodeDescription() {
        "${code} - ${description}"
    }
}
