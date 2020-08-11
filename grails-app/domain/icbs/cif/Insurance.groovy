package icbs.cif

import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus

class Insurance {
        static belongsTo = [customer:Customer]
        
        String lifeInsurance	
        Date lifeDateOfRemittance	
        String pcic	
        Date pcicDateOfRemittance
        String memBenefitProgram
        Date memDateOfRemittance
        String agfp	
        Date agfpDateOfRemitance
        String fireInsurance
        Date fireDateOfRemittance
        

    static constraints = {
        customer nullable:false
        lifeInsurance nullable:true	
        lifeDateOfRemittance nullable:true	
        pcic nullable:true
        pcicDateOfRemittance nullable:true
        memBenefitProgram nullable:true
        memDateOfRemittance nullable:true
        agfp nullable:true	 
        agfpDateOfRemitance nullable:true
        fireInsurance nullable:true
        fireDateOfRemittance nullable:true
      
    }
    
    static mapping = {
        id sqlType: "int", generator: "increment"
    }
    boolean deleted
    static transients = ['deleted']
    
}
