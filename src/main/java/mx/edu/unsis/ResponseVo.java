package mx.edu.unsis;

/**
 *Clase que se usa para enviar la respuesta al cliente
 * @author VICENTE
 */
public class ResponseVo {

        /*Guarda el estado si el password es correcto o no*/
	private boolean successPassword;
        /*guarda el status del token*/
	private boolean successToken;
        /*especifica si el recurso fue invocado usando el método POST*/
	private boolean post;
        /*especifica si el recurso fue invocado usando el método GET*/
	private boolean get;
        /*Especifica el tipo de  respuesta para el cliente*/
	private String messageType;
	
    /**
     *COnstructor vacio
     */
    public ResponseVo(){}
	
    /**
     *Constructor de la clase, donde se incializan sus atributos con valores
     * enviados cuando se intancía esta clase
     * @param successPassword true si es password es correcto, false en caso contrario
     * @param post true si el método que se usó para invocar al servicio fue POST, false en caso contrario
     * @param get true si el método que se usó para invocar al servicio fue GET, false en caso contrario
     * @param message especifica el tipo de mensaje de respuesta
     */
    public ResponseVo(boolean successPassword, boolean post, boolean get, String message){
		this.successPassword = successPassword;
		this.post = post;
		this.get = get;
		this.messageType = message;
	}
	
    /**
     *
     * @return successPasword
     */
    public boolean issuccessPassword() {
		return successPassword;
	}

    /**
     *
     * @param successPassword
     */
    public void setsuccessPassword(boolean successPassword) {
		this.successPassword = successPassword;
	}

    /**
     *
     * @return
     */
    public String getMessageType() {
		return messageType;
	}

    /**
     *
     * @param messageType
     */
    public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

    /**
     *
     * @return the post
     */
    public boolean isPost() {
		return post;
	}

    /**
     *
     * @param post
     */
    public void setPost(boolean post) {
		this.post = post;
	}

    /**
     *
     * @return the get
     */
    public boolean isGet() {
		return get;
	}

    /**
     *
     * @param the get
     */
    public void setGet(boolean get) {
		this.get = get;
	}

    /**
     *
     * @return the isSuccessToken
     */
    public boolean isSuccessToken() {
		return successToken;
	}

    /**
     *
     * @param successToken the isSuccessToken
     */
    public void setSuccessToken(boolean successToken) {
		this.successToken = successToken;
	}


}

