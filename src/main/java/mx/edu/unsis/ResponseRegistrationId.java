package mx.edu.unsis;

public class ResponseRegistrationId {

	public static final int KAO=0;
	public static final int OK=1;
	//Codigo de la respuesta de confirmación
	private int codeResponse;
	//Mensaje de la respuesta
	private String messageResponse;

	public int getCodeResponse() {
		return codeResponse;
	}
	public void setCodeResponse(int codeResponse) {
		this.codeResponse = codeResponse;
	}
	public String getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}
}