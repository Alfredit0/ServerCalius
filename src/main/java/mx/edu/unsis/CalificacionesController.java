/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.request.CalificacionesRequest;
import mx.edu.request.LoginUser;
import mx.edu.request.MateriasRequest;
import mx.edu.request.VerifyUserCode;
import mx.edu.unsis.model.CalificacionesAlumno;
import mx.edu.unsis.model.MateriasAlumno;
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
    CalificacionesService c;//coneción con la BD, para la tabla calificaciones
    
    //variable para el debug del sistema
    private static final Logger logger = LoggerFactory.getLogger(CalificacionesController.class);
    
    /** 
     * Servicio web que devuelve las calificaciones de un determinado alumno
     * @param response Objeto response por el cuál se envía el valor de retorno
     * @param request objeto que recibe de la peticion del cliente
     *                  contiene la matricula del alumno del que se desea consultar 
     *                  sus calificaciones
     * @return objeto json con las calificaciones del alumno, devuleve un objeto vacío
     *         si no se encontraron calificaciones para el alumno especificado
     */
    @RequestMapping(value = "/calificaciones",method = RequestMethod.POST)
    public @ResponseBody String calificaciones(HttpServletResponse response, @RequestBody CalificacionesRequest request){
	    JsonObject r = new JsonObject();
            String passCon = request.getPasscon();
            String idUser = request.getIduser();
            String periodo = request.getPeriodo();
            logger.info("passcon "+passCon+" iduser "+idUser + " peiodo "+periodo);
            Gson gson = new Gson();
            JsonArray array = new JsonArray();
            List<CalificacionesAlumno> ca = this.c.getCalificacionesByAlumno(idUser, periodo);
            for(CalificacionesAlumno c: ca){
                JsonObject object = new JsonObject();
                object.addProperty("materiaId", c.getMateriaId());
                object.addProperty("ordinario", c.getOrdinario());
                object.addProperty("parcial1", c.getParcial1());
                object.addProperty("parcial2", c.getParcial2());
                object.addProperty("parcial3", c.getParcial3());
                array.add(object);
            }
	    if(passCon.equals("12345")){
                r.addProperty("statuscon", true);
                r.add("calificaciones", array);
	    }else{
	        r.addProperty("statuscon", false);
	    }
            logger.info(r.toString());
	    response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
	    response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Content-Type", "application/json; charset=UTF-8");
	    //response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}
    
    /** 
     * Servicio web que devuelve una lista de materias que está cursando actualmente
     * un determinado alumno
     * @param response objeto sobre el cuál se envía la respuesta al cliente
     * @param request Objeto que envía el cliente con la petición, Incluye la
     *                  matricula del alumno y el perido que se está cursando
     * @return una lista con las materias del alumno, una lista vacía para el caso
     *          que no encuentre materias para el alumno especificado
     */
    @RequestMapping(value = "/materias",method = RequestMethod.POST)
    public @ResponseBody String materias(HttpServletResponse response, @RequestBody MateriasRequest request){
	    JsonObject r = new JsonObject();
            String passCon = request.getPasscon();
            String idUser = request.getIduser();
            String periodo = request.getPeriodo();
            logger.info("passcon "+passCon+" iduser "+idUser + " peiodo "+periodo);
            JsonArray array = new JsonArray();
            List<MateriasAlumno> ma = this.c.getMateriasByAlumno(idUser, periodo);
            for(MateriasAlumno m : ma){
                JsonObject object = new JsonObject();
                object.addProperty("idMateria", m.getIdMateria());
                object.addProperty("nombreMateria", m.getNombreMateria());
                array.add(object);
            }
	    if(passCon.equals("12345")){
                r.addProperty("statuscon", true);
                r.add("materias", array);
	    }else{
	        r.addProperty("statuscon", false);
	    }
            logger.info(r.toString());
	    response.setContentType("application/json");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
	    return r.toString();
	}
    /** 
     * Servicio web que provee al cliente el periodo
     * @param response Objeto response por el cuál se envía el valor de retorno
     * @return Un String con el periodo actual
     */
    @RequestMapping(value = "/periodo",method = RequestMethod.GET)
    public @ResponseBody String periodo(HttpServletResponse response){
	    JsonObject r = new JsonObject();
            String año, periodo="";
            //se calcula el periodo actual
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
