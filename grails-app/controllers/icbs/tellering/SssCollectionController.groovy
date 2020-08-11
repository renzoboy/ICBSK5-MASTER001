package icbs.tellering

class SssCollectionController {

    def index() { }
    
    def create() {
        def txnFileInstance = new TxnFile()
        respond txnFileInstance
    }
    
    def save() {
        redirect(controller:"tellering", action:"index")
    }
}
