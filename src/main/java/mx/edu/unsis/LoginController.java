/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import mx.edu.request.*;
import mx.edu.unsis.model.Usuarios;
import mx.edu.unsis.model.UsuariosTemp;
import mx.edu.unsis.service.UsuariosService;
import mx.edu.unsis.service.UsuariosTempService;

/**
 *
 * @author Mirna
 */
@Controller
public class LoginController {
    @Autowired
    private UsuariosService usv;
    
    @Autowired
    private UsuariosTempService ustemp;
    
    private static final Logger Logger = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping(value = "/loginuser",method = RequestMethod.POST)
    public @ResponseBody String loginUser(Model model, HttpServletResponse response, @RequestBody LoginUser request){
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	        Usuarios u = this.usv.loginUser(request.getIduser(),request.getPassword(), 2);
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
	    return r.toString();
    }
    
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public @ResponseBody String AddUser(Model model, HttpServletResponse response, @RequestBody AddUser request){
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	    	Usuarios usuario = new Usuarios();
	    	usuario = this.usv.getUsuarioById(request.getIduser());
	        if(usuario!=null){
	            r.addProperty("statuscon", true);
	            r.addProperty("idstatus", false);
	            r.addProperty("procstatus", false);
	        }
			else{	  
			    UsuariosTemp u = new UsuariosTemp();
			    u.setUsuarioId(request.getIduser());	        
			    u.setUsuarioTelefono(request.getPhone());	
			    String code = generarCodigo();
			    System.out.println(code);
			    u.setUsuarioCodigo(code);
			    this.ustemp.insertUsuarioTemp(u);
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
	    return r.toString();
	}
    
    @RequestMapping(value = "/verifyusercode",method = RequestMethod.POST)
    public @ResponseBody String VerifyUserCode(Model model, HttpServletResponse response, @RequestBody VerifyUserCode request){
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	        
	        if(!this.ustemp.verificarCodigoUsuario(request.getIduser(),request.getCode())){
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
	    return r.toString();
	}
    
    @RequestMapping(value = "/saveuserpass",method = RequestMethod.POST)
    public @ResponseBody String SaveUserPass(Model model, HttpServletResponse response, @RequestBody SaveUserPass request){
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	        /*Usuarios u = this.usv.saveUserPass(request.getIduser(),request.getPassword());
	        if(u==null){
	            r.addProperty("statuscon", true);
	            r.addProperty("status", false);
	        }else{
	            
	            r.addProperty("statuscon", true);
	            r.addProperty("status", true);
	        }*/
	    }else{
	        
	            r.addProperty("statuscon", false);
	            r.addProperty("status", false);
	    }
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}
    
    public String generarCodigo(){
    	String cod="";
    	cod=""+ThreadLocalRandom.current().nextInt(0, 8 + 1)+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	cod=cod+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	cod= cod+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	return cod;
    }
}
