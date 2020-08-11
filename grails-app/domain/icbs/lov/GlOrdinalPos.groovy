package icbs.lov

class GlOrdinalPos {
    String description
    String idvalue
    Integer transactionType
    static constraints = {
        description nullable: true
        idvalue nullable: true
        transactionType nullable: true        
    }
}
