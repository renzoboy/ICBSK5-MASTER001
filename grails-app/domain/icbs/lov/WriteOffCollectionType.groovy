package icbs.lov

class WriteOffCollectionType {
    String code
    String description
    String shortDescription
    boolean status

    static constraints = {
    	code unique:true
    	description unique:true
        shortDescription nullable:true
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
