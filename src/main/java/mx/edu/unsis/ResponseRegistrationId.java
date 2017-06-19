package mx.edu.unsis;

public class ResponseRegistrationId {

	public static final int KAO=0;
	public static final int OK=1;
	//Código de la respuesta de confirmación
	private int codeResponse;
	//Mensaje de la respuesta
	private String messageResponse;
	/**
	 * se obtiene el codigo de confirmacion
	 * @return el codigo de confirmacion
	 */
	public int getCodeResponse() {
		return codeResponse;
	}
	/**
	 * se asigna el codigo de confirmacion a la variable code Response
	 * @param codeResponse
	 */
	public void setCodeResponse(int codeResponse) {
		this.codeResponse = codeResponse;
	}
	/**
	 * se obtiene e mensaje de la respuesta
	 * @return el mensaje en la vaiable massageResponse
	 */
	public String getMessageResponse() {
		return messageResponse;
	}
	/**
	 * asinga el mensaje a la variable messageResponse 
	 * @param messageResponse
	 */
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}
}