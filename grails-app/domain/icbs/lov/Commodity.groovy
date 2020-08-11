package icbs.lov

class Commodity {
	String code
	String description
        String shortDescription
        Double rate
	boolean status

    static constraints = {
    	code maxSize:10, unique:true
    	description maxSize:75, unique:true
        rate nullable:true
        shortDescription nullable:true
        status nullable:true
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
