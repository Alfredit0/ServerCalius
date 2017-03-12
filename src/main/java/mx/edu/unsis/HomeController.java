package mx.edu.unsis;

import java.io.IOException;
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

import mx.edu.unsis.ResponseVo;
import mx.edu.unsis.RequestVo;

import mx.edu.unsis.model.Users;
import mx.edu.unsis.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService usv;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Users p = this.usv.getUserById("2013060024");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("matricula", p.getUser_id());
		
		return "home";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody ResponseVo login(
			HttpServletResponse response, 
			@RequestBody RequestVo req
			) throws IOException{

		logger.info("************ENTRANDO AL METODO DE LOGIN*********************");
		ResponseVo res = new ResponseVo();
		
		Users p = this.usv.getUserById("2013060024");				
		
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
}
