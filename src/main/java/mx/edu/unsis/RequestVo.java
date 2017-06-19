package mx.edu.unsis;

public class RequestVo {

	public String password;
	public String token;
	public String id;
	/**
	 * se obtiene la contraseña
	 * @return el valor de password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * se asigna la contreseña a la variable passcon
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * se obtiene un elemento
	 * @return el valor de token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * se asigna el elemento a la variable token
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * se obtiene el identificador
	 * @return se regresa el valor del id
	 */
	public String getId() {
		return id;
	}
	/**
	 * se asigna id identificador a la variable id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
