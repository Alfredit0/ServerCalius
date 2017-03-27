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
import mx.edu.unsis.dao.UsuarioDAO;
import mx.edu.unsis.RequestVo;

import mx.edu.unsis.model.Usuarios;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends WebMvcConfigurerAdapter{

	@Autowired
	private UsuarioDAO usv;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// Ubicación del fichero donde se persistira el identificador de registro
	  public static final String PATH = "C:/Users/Meltsan/Documents/servidor/registration-id.txt";

	//Url que necesitaremos para invocar el servicio de envio de notificaciones a los servidores de GCM
	public static String URL_GOOGLE_CLOUD_MESSAGE="https://android.googleapis.com/gcm/send";

	//La API_KEY se inicializa con el valor obtenido desde la api console 
	public static String API_KEY="AIzaSyDJbDWIjqdcBGTxm0Xe798Rg9TyAKyNYGE";

	private static final long serialVersionUID = 1L;	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Usuarios u = new Usuarios();
		u.setUsuarioId("2013060015");
		u.setUsuarioIdGcm("125");
		u.setUsuarioPassword("admin123");
		u.setUsuarioTelefono("9512197933");
		this.usv.insertUsuario(u);
		this.usv.getUsuarioById(u.getUsuarioId());
		u.setUsuarioIdGcm("111");
		this.usv.updateUsuario(u);
		this.usv.getAllUsers();
		this.usv.loginUser(u.getUsuarioId(), u.getUsuarioPassword());
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		//model.addAttribute("matricula", p.getUser_id());

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseVo login(
			HttpServletResponse response, 
			@RequestBody RequestVo req
			) throws IOException{

		logger.info("************ENTRANDO AL METODO DE LOGIN*********************");
		ResponseVo res = new ResponseVo();

		Usuarios p = this.usv.getUsuarioById("2013060024");				

		if(!"12345".equals(req.getPassword())){
			res.setsuccessPassword(false);
			res.setSuccessToken(false);
			res.setMessageType("POST");
			res.setPost(true);
		} else {
			res.setsuccessPassword(true);
			res.setSuccessToken(true);
			res.setMessageType("POST");
			res.setPost(true);
		}

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return res;
	}

	/**
	 * SERVICIO PARA REGISTRO DEL ID DE NOTIFICACION
	 */

	@RequestMapping(value = "/registeridnotification", method = RequestMethod.POST)
	public @ResponseBody ResponseRegistrationId registeridnotification(
			HttpServletResponse response, 
			@RequestBody RequestRegistrationId req
			) throws IOException{

		 ResponseRegistrationId responseRegistrationId = new ResponseRegistrationId();
		    try {
		        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
		            new File(PATH)));
		        bufferedWriter.write(req.getRegistrationId());
		        bufferedWriter.flush();
		        bufferedWriter.close();
		        responseRegistrationId.setCodeResponse(ResponseRegistrationId.OK);
		        responseRegistrationId
		            .setMessageResponse("Registro efectuado satisfactoriamente");
		      } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        responseRegistrationId.setCodeResponse(ResponseRegistrationId.KAO);
		        responseRegistrationId.setMessageResponse(e.getMessage());
		      }
		      		 
		//Cabeceras de respuesta
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		return responseRegistrationId;
	}

	/**
	 * SERVICIO PARA EL ENVIO DE NOTIFICACIONES
	 */
	@RequestMapping(value = "/sendnotification", method = RequestMethod.POST)
	public @ResponseBody ResponseVo sendnotification(
			HttpServletResponse response, 
			@RequestBody RequestVo req
			) throws IOException{

		logger.info("************ENTRANDO AL METODO DE ENVIAR NOTIFICATION*********************");


		//Recuperamos el mensaje de la notificación introducido y enviado a traves del formaluario web de index,jsp
		String mensaje ="Hola mundo";
		//Se lee el identificador de registro guardado previamente a traves del servicio REST
		String idRegistro=recuperarIdRegistro();
		//A partir de aqui se crea un objeto JSON que envuelve todos los parametros que le mandaremos al servicio de GCM
		JsonObject jsonObject = new JsonObject();
		JsonObject data = new JsonObject();
		data.addProperty("mensaje",mensaje);
		JsonArray registration_ids = new JsonArray();
		registration_ids.add(new JsonPrimitive(idRegistro));
		/*
		 * Por convención el objeto Json tendrá como mínimo los siguientes atributos "data" y "registration_ids" 
		 * aunque hay muchos otros atributos que son opcionales. En este ejemplo solo se pasa por parametro un único identificador
		 * de registro pero como pueden ser mas de uno estos se encapsulan en un array de identifiacdores de registro, con 
		 * lo que es posible mandar una misma notificación a multiples dispositivos Android
		 */
		jsonObject.add("data",data);
		jsonObject.add("registration_ids",registration_ids);
		//Justo en la siguiente linea de codigo se invoca el servicio GCM de envio de notificaciones 
		//y este nos devuelve una respuesta de confirmación
		String respuesta = invocarServicioGCM(jsonObject.toString(),new URL(URL_GOOGLE_CLOUD_MESSAGE),API_KEY);

		//Se almacena el mensaje de la notificación en el contexto de request para luego poder mostrarlo en la JSP de confirmación

		//Por ultimo redirigimos hacia la jsp que visualiza la confirmación del envio de la notificacion



		// Retorno de valores x
		ResponseVo res = new ResponseVo();
		res.setsuccessPassword(true);
		res.setSuccessToken(true);
		res.setMessageType("TEST NOTICATION");
		res.setPost(true);

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return res;
	}	

	/**
	 * Metodo que permite recuperar el identificador de registro que asido previamente guardado   en registration-id.txt por el
	 * servicio REST implementado por la clase RegisterIdService.
	 * @return Devuelve el identificador de registro
	 * @throws IOException
	 */
	private static final String recuperarIdRegistro() throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(PATH)));
		String registroId = bufferedReader.readLine();  
		bufferedReader.close();   
		return registroId;
	}

	/**
	 * Metodo que implementa un cliente del servicio REST de GCM que se encarga del envio de las  notificaciones
	 * @param json Objeto Json que envuelve un array con los destinatarios (array con   identificadores de registro) 
	 * y  los datos de la notificación (el mensaje en este ejemplo)
	 * @param url Es la url del servicio REST de envio de notificaciones de GCM
	 * @param apikey Es la clace del servidor con la que podemos acceder a una instancia de los   servicios de Google Play Services
	 * @return Devuelve la respuesta de confirmación del servicio REST
	 */
	public static final String invocarServicioGCM(final String json, final URL url,final String apikey){
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept-Encoding", "application/json");
			//Se pasa el Api key como parametro de la cabecera de la petición http
			conn.setRequestProperty("Authorization","key=" +apikey);
			if(json!=null){
				conn.setDoOutput(true);
				OutputStream os = conn.getOutputStream();
				os.write(json.getBytes("UTF-8"));
				os.flush();
			}

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String outputLine;
			StringBuffer totalSalida = new StringBuffer();
			System.out.println("Output from Server .... \n");
			while ((outputLine = br.readLine()) != null) {
				totalSalida.append(outputLine/*new String(outputLine.getBytes("ISO-8859-1"), "UTF-8")*/);
			}
			conn.disconnect();
			return totalSalida.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	  

}
