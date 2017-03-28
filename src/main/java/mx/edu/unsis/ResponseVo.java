package mx.edu.unsis;

public class ResponseVo {


	private boolean successPassword;
	private boolean successToken;
	private boolean post;
	private boolean get;
	private String messageType;
	
	public ResponseVo(){}
	
	public ResponseVo(boolean successPassword, boolean post, boolean get, String message){
		this.successPassword = successPassword;
		this.post = post;
		this.get = get;
		this.messageType = message;
	}
	
	public boolean issuccessPassword() {
		return successPassword;
	}

	public void setsuccessPassword(boolean successPassword) {
		this.successPassword = successPassword;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public boolean isPost() {
		return post;
	}

	public void setPost(boolean post) {
		this.post = post;
	}

	public boolean isGet() {
		return get;
	}

	public void setGet(boolean get) {
		this.get = get;
	}

	public boolean isSuccessToken() {
		return successToken;
	}

	public void setSuccessToken(boolean successToken) {
		this.successToken = successToken;
	}


}

