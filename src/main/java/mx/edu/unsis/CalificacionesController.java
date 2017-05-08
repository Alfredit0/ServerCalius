/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis;

import com.google.gson.JsonObject;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.request.CalificacionesRequest;
import mx.edu.request.LoginUser;
import mx.edu.request.VerifyUserCode;
import mx.edu.unsis.service.CalificacionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author VICENTE
 */
@Controller
public class CalificacionesController extends WebMvcConfigurerAdapter {
    
    @Autowired
    CalificacionesService c;
    
    private static final Logger logger = LoggerFactory.getLogger(CalificacionesController.class);
    
    @RequestMapping(value = "/calificaciones",method = RequestMethod.POST)
    public @ResponseBody String calificaciones(Model model, HttpServletResponse response, @RequestBody CalificacionesRequest request){
	    JsonObject r = new JsonObject();
            String passcon = request.getPasscon();
            String iduser = request.getIduser();
            String periodo = request.getPeriodo();
            logger.info("passcon "+passcon+" iduser "+iduser + " peiodo "+periodo);
	    if(passcon.equals("12345")){
                r.addProperty("statuscon", true);
                r.addProperty("calificaciones", this.c.getCalificacionesByAlumno(iduser, periodo).toString());
	    }else{
	        r.addProperty("statuscon", false);
	    }
            logger.info(r.toString());
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}
    
    @RequestMapping(value = "/periodo",method = RequestMethod.GET)
    public @ResponseBody String periodo(Model model, HttpServletResponse response){
	    JsonObject r = new JsonObject();
            String año, periodo="";
            Calendar fecha = Calendar.getInstance();
            año = String.valueOf(fecha.get(Calendar.YEAR));
		int mes = fecha.get(Calendar.MONTH);
		if(mes>=9 || mes <=1){
			periodo = año+"-A";
		}else if(mes>=2 && mes <=6){
			periodo = año+"-B";
		}
		logger.info("Periodo Actual --> "+periodo);
            r.addProperty("periodo", periodo);
            logger.info(r.toString());
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}
    
}
