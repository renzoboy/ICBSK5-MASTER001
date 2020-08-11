package icbs.lov

class SssPayorType {

    String code
	String description
        String shortDescription
	boolean status

    static constraints = {
    	code maxSize:10, unique:true
    	description maxSize:75, unique:true
        shortDescription nullable:true, maxSize:10
    }

    String toString() {
        return description
    }

    String getCodeDescription() {
        "${code} - ${description}"
    }
    
    static mapping = {
        id sqlType:'int', generator:'increment'
    } 
}
