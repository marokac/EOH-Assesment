
package com.qpoint.controller;
import com.qpoint.Cic.mailCic;
import com.qpoint.Cic.Email;
import com.qpoint.Cic.mailCicService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@Controller
public class controller {
    
    @Autowired
    private PictureServiceDao pictureService;
    @Autowired
    private UserReqService userService;
    
         @Autowired
         private mailCicService cicService; 
         //-------------------------Retrive CIC Information------------------------------
        
        @RequestMapping(value="/api/cic/{id}", method=RequestMethod.GET)
         @ResponseBody public List getAllCom(@RequestParam("id") int id ){
             return mailCicService.findById(id);
         }
    
         }
         //---------------------Register CIC------------------------------
         @CrossOrigin
         @RequestMapping(value="/api/addCic",method=RequestMethod.POST)
         public @ResponseBody void addCic(@RequestBody mailCic cic){
          mailCicService.addCic(cic);
         }
           //---------------------update CIC------------------------------
         @CrossOrigin
         @RequestMapping(value="/api/updateCic",method=RequestMethod.POST)
         public @ResponseBody void updateCic(@RequestBody mailCic cic) {
             mailCicService.updateCic(cic);
  //---------------------delete CIC------------------------------
        @CrossOrigin
         @RequestMapping(value="/api/deleteCic",method=RequestMethod.POST)
         public @ResponseBody void deleteCic(mailCic cic){
         mailCicService.deleteCic(cic.getId());
         }
  //---------------------Get All cic ------------------------------
         @CrossOrigin
         @RequestMapping(value="/api/getAllCic", method=RequestMethod.GET)
         @ResponseBody public List getAllCic(){
             return mailCicService.findAllCic();
         }
//---------------------Bad Request------------------------------
         @CrossOrigin
         @RequestMapping(value="/*",method=RequestMethod.GET)
         public String getErrorPage(){
         return "resources/Error.html";
         }

         //---------------------send email Request------------------------------
         @CrossOrigin
         @RequestMapping(value="/sendMail",method=RequestMethod.GET)
          @ResponseBody public String sendMail(Email email){
             List<mailCic> allCic mailCicService.findAllCic()// cic list
             List<Email> allEmails mailCicService.findAllEmail();//email list
             //send email only if the id's are equal
             for(int i=0;i<allCic.size();i++){
                 for(int j=0;j<allEmails.size();j++){
                     if(allCic.get(i).getId()==allEmails.get(j).getId()){
                       sendMail(allEmails.get(j),allCic.get(i));
                     }
                     
                 }
               
             }
             return "mail send"
         }

          @Autowired
          private JavaMailSender mailSenderObj;

           String mailTo,mailMessage,emailSubject,mailBody;

           public void sendMail(Email email,mailCic cic){
        
           mailTo=email.getEmailAdress();
           emailSubject=cic.getSubjectt();
           mailBody=cic.getBody();
           mailMessage="<h2 style='color:#FF8C00;'>EOH Test</h2><h4>Dear  "+"Customer"+ " </h4> <p style='margin:20px; text-align:center; font-size:14px;'> "+ mailBody + "</p><br><p>Kindly Regards:</p><div style='padding:20px;text-align:center; background:blue;color:white;width:100%;'><h3>EOH Test Team</h3><p>For more information you can contuct MR Cedric Maroka at 0827943118</p></div>";
               mailSenderObj.send(new MimeMessagePreparator(){
              //mail to customer 
               @Override
               public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
                mimeMessage.setContent(mailMessage, "text/html");
                mimeMsgHelperObj.setTo(mailTo);
                mimeMsgHelperObj.setFrom("marokac45@gmail.com");               
                mimeMsgHelperObj.setSubject(emailSubject);
                
            }

           })
        

         }
}
