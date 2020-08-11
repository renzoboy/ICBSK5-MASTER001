package icbs.admin

import groovy.sql.Sql
import java.io.*; // ito giezel need 
import java.net.*;
import java.util.*; // ito giezel need
import java.util.concurrent.ConcurrentHashMap;
import org.*
import grails.converters.JSON
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.json.parser.JSONParser
import org.springframework.web.context.request.RequestContextHolder
import javax.servlet.http.HttpSession
import java.text.DateFormat; // ito giezel need
import java.text.SimpleDateFormat; // ito giezel need
import java.util.Calendar; // ito giezel need
import java.util.Date; // ito giezel need
import java.util.Formatter.DateTime // ito giezel need
import java.util.Iterator; 
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.codec.binary.Base64;
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.admin.Currency

@Transactional
class MultisysService {
    
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateFormat multisysRefDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private HttpURLConnection  myURLConnection;
    def dataSource 
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE", saveCharge: "PUT"]
    String resultValue = null
    def multisysService
    
    def serviceMethod() {

    }
    def sendSmsMultisys(String messageContent,String custMobileNumber,params){
        custMobileNumber = "09454960580"
        messageContent = "Thank you, We Already received your payment amount of 3,000 PHP"
        //  set parameters
        

        params.put("message",messageContent)
        params.put("number",custMobileNumber)
        
        // call function to send request to Multisys Server
        def responseFromICBS = portalProcessParameters(params)
        //Read JSON response and print
            println("RESPONSE ORIGINAL: "+responseFromICBS.toString())
            JSONObject myResponse = new JSONObject(responseFromICBS.toString());
            println("myResponse: "+myResponse)
            //println("myResponse.reason: "+myResponse.getString("reason"))
            //println("myResponse.status: "+myResponse.getString("status"))
            //println("myResponse.data: "+myResponse.getString("data"))
            //println("getJSONObject data: "+myResponse.getJSONObject("data"))
            
            // parse array from json 
            //JSONObject dataResponse = myResponse.getJSONObject("data");
            
            // get URL
            //println("URL DATA: "+dataResponse.getString("url"))
            //def reponseDetails = [:]
            //reponseDetails.put('reason',myResponse.getString("reason"))
            //reponseDetails.put('status',myResponse.getString("status"))
            //reponseDetails.put('dataUrl',dataResponse.getString("url"))
            
            //[reponseDetails:reponseDetails]
            
            
    }
    def portalProcessParameters(params){
        println("============= portalProcessParameters ================")
        println("params: "+params)
        
        URL url = null;
        String action = "";
        action = "Echo";
        String jmXSecurityCode = "";
        String jmXConnectionUrl = "";
        String multisysAuthenticationKey = Institution.findByParamCode("MSYS.10102").paramValue.toString()
        String multisysAuthenticationValue = Institution.findByParamCode("MSYS.10103").paramValue.toString()
        String multiSysCode = "TBILLER";
        String callBackUrl = "";
        try {
            if("Echo".equals(action)){
                System.out.println("AAA");

                jmXConnectionUrl = Institution.findByParamCode("MSYS.10101").paramValue.toString()
                println("jmXConnectionUrl: "+jmXConnectionUrl)
                url = new URL(jmXConnectionUrl);
            }
            // required item to validate request

            
            StringBuilder postData = new StringBuilder();
            
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty(""+multisysAuthenticationKey, ""+multisysAuthenticationValue);
            
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
                     
            Reader insx = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

            //==========================
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = insx.readLine()) != null) {
               response.append(inputLine);
            }
            insx.close();
            //print in String
            return response
        } 
        catch (MalformedURLException e) { 
            //System.out.println(e);
            // new URL() failed
            
            // ...
        }  
    }
}
