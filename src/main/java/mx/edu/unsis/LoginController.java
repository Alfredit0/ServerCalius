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
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import mx.edu.request.*;
import mx.edu.unsis.model.Administrativos;
import mx.edu.unsis.model.Alumnos;
import mx.edu.unsis.model.Usuarios;
import mx.edu.unsis.model.UsuariosTemp;
import mx.edu.unsis.service.AdministrativosService;
import mx.edu.unsis.service.AlumnosService;
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
    
    @Autowired
    private AlumnosService asv;
    
    @Autowired
    private AdministrativosService adsv;
    
    private static final Logger Logger = LoggerFactory.getLogger(LoginController.class);
    
    //Credenciales para el servicio de TWILIO
    public static final String ACCOUNT_SID = "ACfd260d809fdea584b042bd82197864a5";
    public static final String AUTH_TOKEN = "78509a7c1dc08ed2587ae7197d65e57a";	
	
    
    @RequestMapping(value = "/loginuser",method = RequestMethod.POST)
    public @ResponseBody String loginUser(Model model, HttpServletResponse response, @RequestBody LoginUser request){
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	        Usuarios u = this.usv.loginUser(request.getIduser(),request.getPassword(), request.getUsuarioTipo());
	        if(u==null){
	            r.addProperty("statuscon", true);
	            r.addProperty("status", false);
	        }else{
                    String nombre="";
	            if(request.getUsuarioTipo()==1){
                        Alumnos alumno = asv.getAlumnoById(request.getIduser());
                        nombre = alumno.getAlumnoNombre();
                    }else if(request.getUsuarioTipo()==2){
                        Administrativos admin = adsv.getAdministrativoById(request.getIduser());
                        nombre= admin.getAdminNombre();
                    }                    
	            r.addProperty("statuscon", true);
	            r.addProperty("status", true);
                    r.addProperty("nombre", nombre);
	        }
	    }else{
	        
	            r.addProperty("statuscon", false);	            
	    }
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
    }
    
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public @ResponseBody String AddUser(Model model, HttpServletResponse response, @RequestBody AddUser request) throws IOException, TwilioRestException{
	    JsonObject r = new JsonObject();
	    if(request.getPasscon().equals("12345")){
	    	Usuarios usuario = new Usuarios();
	    	usuario = this.usv.getUsuarioById(request.getIduser());
	        if(usuario!=null){
	            r.addProperty("statuscon", true);
	            r.addProperty("idstatus", false);
	            r.addProperty("procstatus", false);
	        }
                else if(this.asv.getAlumnoById(request.getIduser()) != null){
                    UsuariosTemp u = new UsuariosTemp();
		    u.setUsuarioId(request.getIduser());	        
		    u.setUsuarioTelefono(request.getPhone());	
		    String code = generarCodigo();
		    System.out.println(code);
		    u.setUsuarioCodigo(code);
		    this.ustemp.insertUsuarioTemp(u);
                    enviarCodigo(request.getPhone(), code);
                    r.addProperty("statuscon", true);
	            r.addProperty("idstatus", true);
	            r.addProperty("procstatus", true);
	        }else{
                    r.addProperty("statuscon", true);
	            r.addProperty("idstatus", false);
	            r.addProperty("procstatus", false);
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
	        UsuariosTemp ut = this.ustemp.getUsuarioTempById(request.getIduser());
	        if(ut!=null){
		        Usuarios u = new Usuarios(); 
		        u.setUsuarioId(ut.getUsuarioId());
		        u.setUsuarioIdGcm(null);
		        u.setUsuarioPassword(request.getPassword());
		        u.setUsuarioTelefono(ut.getUsuarioTelefono());
		        u.setUsuarioTipo(1);
		        this.usv.insertUsuario(u);
		        this.ustemp.eliminarUsuarioTemp(ut.getUsuarioId());
	            r.addProperty("statuscon", true);
	            r.addProperty("status", true);
	        }else{
	            
	            r.addProperty("statuscon", true);
	            r.addProperty("status", false);
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
    
    public String generarCodigo(){
    	String cod="";
    	cod=""+ThreadLocalRandom.current().nextInt(0, 8 + 1)+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	cod=cod+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	cod= cod+""+ThreadLocalRandom.current().nextInt(0, 8 + 1);
    	return cod;
    }
    
            /*
        *
        */	
	public void enviarCodigo(String numero, String cod) throws IOException, TwilioRestException {
            
            //Numero al cual enviar el codigo
            String telefono = "+52"+numero;
            
            //codigo
            String codigo = numerosALetras(cod);
	        
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			Account mainAccount = client.getAccount();
			CallFactory callFactory = mainAccount.getCallFactory();
			Map<String, String> callParams = new HashMap<String, String>();
			callParams.put("To", telefono);
			callParams.put("From", "523353516707");
			String url ="https://calius.herokuapp.com/TwilServlet?token="+codigo;
			//url= (String)java.net.URLEncoder.encode(url,"UTF-8").replace("+", "%20");
			url=url.replaceAll(" ", "%20");
			callParams.put("Url",url );
			Call call;
                        call = callFactory.create(callParams);
                        System.out.println(call.getSid());
	}      
        
        public String numerosALetras(String codigo){
        String cod;
        String[] numeros={"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve"};
        int n1 = Integer.parseInt(""+codigo.charAt(0))-1;
        int n2 = Integer.parseInt(""+codigo.charAt(1))-1;
        int n3 = Integer.parseInt(""+codigo.charAt(2))-1;
        int n4 = Integer.parseInt(""+codigo.charAt(3))-1;
        cod = numeros[n1]+" , "+numeros[n2]+" , "+numeros[n3]+" , "+numeros[n4];
        return cod;
        }
}
