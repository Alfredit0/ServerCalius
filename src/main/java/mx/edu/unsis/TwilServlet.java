/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 *
 * @author Meltsan
 */
public class TwilServlet extends HttpServlet {
    /*Identificador para el servicio de la API de llamadas*/
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
         * se recibe el token, y se procede a definir los parametros de llamada
         * y se invoca al servicio proporcionado por la API twilio para realizar
         * la llamda.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getParameter("token");
		// Create a TwiML response and add our friendly message.
        TwiMLResponse twiml = new TwiMLResponse();
        System.out.println(token);
        //se especifica el mensaje que queremos oir
        Say say = new Say("Tu codigo de verificacion es: " + token);
        //se indica el tipo de voz a usar
        say.setVoice("man");        
        //se especifica el lenguaje
        say.setLanguage("es-MX");        
        //Play play = new Play("http://demo.twilio.com/hellomonkey/monkey.mp3");
        //play.setLoop(10);
        try {
            twiml.append(say);
            twiml.append(say);
            //twiml.append(play);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
