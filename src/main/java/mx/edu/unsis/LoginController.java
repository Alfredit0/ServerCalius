/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mirna
 */
@Controller
public class LoginController {
    @Autowired
    private UserService usv;
    
    private static final Logger Logger = LoggerFactory.getLogger(LoginController.class);
    
    @requestMapping(value = "/loginuser",method = RequestMethod.POST)
    public JsonObject loginUser(Model model, HttpServletResponse response. @RequestBody LoginUser request){
    JsonObject r = new JsonObject();
    if(request.getPasscon().equals("12345")){
        Users u = this.usv.loginUser(request.getIdUser(),request.getPassword());
        if(u==null){
            r.addProperty("statuscon", true);
            r.addProperty("status", false);
        }else{
            
            r.addProperty("statuscon", true);
            r.addProperty("status", true);
        }
    }else{
        
            r.addProperty("statuscon", false);
            r.addProperty("status", false);
    }
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
    return r;
}
    
    @requestMapping(value = "/adduser",method = RequestMethod.POST)
    public JsonObject AddUser(Model model, HttpServletResponse response. @RequestBody AddUser request){
    JsonObject r = new JsonObject();
    if(request.getPasscon().equals("12345")){
        Users u = this.usv.addUser(request.getIdUser(),request.getphone());
        if(u==null){
            r.addProperty("statuscon", true);
            r.addProperty("idstatus", false);
            r.addProperty("procstatus", false);
        }else{
            
            r.addProperty("statuscon", true);
            r.addProperty("idstatus", true);
            r.addProperty("procstatus", true);
        }
    }else{
        
            r.addProperty("statuscon", false);
            r.addProperty("idstatus", false);
            r.addProperty("procstatus", false);
    }
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
    return r;
}
    
     @requestMapping(value = "/verifyusercode",method = RequestMethod.POST)
    public JsonObject VerifyUserCode(Model model, HttpServletResponse response. @RequestBody VerifyUserCode request){
    JsonObject r = new JsonObject();
    if(request.getPasscon().equals("12345")){
        Users u = this.usv.verifyUserCode(request.getIdUser(),request.getCode());
        if(u==null){
            r.addProperty("statuscon", true);
            r.addProperty("status", false);
        }else{
            
            r.addProperty("statuscon", true);
            r.addProperty("status", true);
        }
    }else{
        
            r.addProperty("statuscon", false);
            r.addProperty("status", false);
    }
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
    return r;
}
    
     @requestMapping(value = "/saveuserpass",method = RequestMethod.POST)
    public JsonObject SaveUserPass(Model model, HttpServletResponse response. @RequestBody SaveUserPass request){
    JsonObject r = new JsonObject();
    if(request.getPasscon().equals("12345")){
        Users u = this.usv.saveUserPass(request.getIdUser(),request.getPassword());
        if(u==null){
            r.addProperty("statuscon", true);
            r.addProperty("status", false);
        }else{
            
            r.addProperty("statuscon", true);
            r.addProperty("status", true);
        }
    }else{
        
            r.addProperty("statuscon", false);
            r.addProperty("status", false);
    }
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
    return r;
}
}
