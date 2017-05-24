package mx.edu.unsis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import mx.edu.unsis.ResponseVo;
import mx.edu.unsis.dao.AlumnosDAO;
import mx.edu.unsis.dao.UsuarioDAO;
import mx.edu.unsis.dao.NotificacionesDAO;
import mx.edu.request.AddUser;
import mx.edu.request.SaveUserPass;
import mx.edu.request.history;
import mx.edu.unsis.RequestVo;
import mx.edu.unsis.model.Usuarios;
import mx.edu.unsis.model.Notificaciones;
import mx.edu.unsis.model.UsuariosTemp;
import mx.edu.unsis.service.AdministrativosService;
import mx.edu.unsis.service.AlumnosService;
import mx.edu.unsis.service.NotificacionesService;
import mx.edu.unsis.service.UsuariosTempService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HistorialController extends WebMvcConfigurerAdapter{

	@Autowired
	private NotificacionesService ndao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	


    @RequestMapping(value = "/historialnotificaciones",method = RequestMethod.POST)
    public @ResponseBody String getNoNotificaciones(Model model, HttpServletResponse response, @RequestBody history request){
	    JsonObject r = new JsonObject();
	    
	    if(request.getPasscon().equals("12345")){
	    	r.addProperty("statuscon", true);
	    	r.addProperty("mensajes", this.ndao.getNoNotificaciones(request.getNo()).toString());
	    	
	    	
	    }else{
	        
	            r.addProperty("statuscon", false);
	    }
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}	


}
