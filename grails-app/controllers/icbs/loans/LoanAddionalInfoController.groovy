package icbs.loans
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql
import java.text.DateFormat
import java.text.SimpleDateFormat
import grails.converters.*
import icbs.loans.LoanAdditonalInfo

class LoanAddionalInfoController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def dataSource
    def index() {}
    def loanInfo(){

    }
    public def dateconvert(String xxdate){
                
                def functiondate
                DateFormat yinputDF  = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                Date dat3 = yinputDF.parse(xxdate)
                Calendar ynow = Calendar.getInstance();
                ynow.setTime(dat3);
                int years = ynow.get(Calendar.YEAR);
                int months = ynow.get(Calendar.MONTH) + 1; // Note: zero based!
                int days = ynow.get(Calendar.DAY_OF_MONTH);
                
               // functiontime = years + "-"+ months +"-"+days + " " + hours +":"+ minutes + ":00";
                functiondate = years + "-"+ months +"-"+ days 
                return functiondate
        
    }
    
    def saveOtherInfo(){  
      def json = request.JSON
      def sql = new Sql(dataSource)
   
    
    def saveAdditionalLoan = new LoanAdditonalInfo(accountNo:json.accntNumber,customerName:json.cstmerName,address:json.address,dateGranted:Date.parse("yyyy-MM-dd",dateconvert(json.dateGrante + " 00:00:00")),maturityDate:Date.parse("yyyy-MM-dd",dateconvert(json.matDate + " 00:00:00")),amountGranted: Double.parseDouble(json.amountGranted),
                                                    accountBalance:Double.parseDouble(json.accntBal),loanDiscountInterest:Double.parseDouble(json.loanDiscount),serviceCharge:Double.parseDouble(json.sc),
                                                    otherDeferredCredits:Double.parseDouble(json.odc),cutoffDate:Date.parse("yyyy-MM-dd",dateconvert(json.cod+ " 00:00:00")),specificAllowance:Double.parseDouble(json.specAll))
    
    saveAdditionalLoan.save(flush:true)
    println saveAdditionalLoan
    render saveAdditionalLoan:saveAdditionalLoan as JSON
    }
    
    
    def searchInfo(){
      def json = request.JSON
      def sql = new Sql(dataSource)
      def srchStr= "select a.id,a.account_no,b.display_name,concat(c.address1 , ' ' , c.address2) as address,"
      srchStr+=" a.date_approved::date,a.maturity_date::date,a.granted_amount,a.balance_amount"
      srchStr+=" from loan a inner join customer b on a.customer_id = b.id"
      srchStr+=" INNER join address c on b.id = c.customer_id where a.id ="+json.id+""
      def exeSearch = sql.rows(srchStr)

      render exeSearch as JSON
        
    }
   
}
