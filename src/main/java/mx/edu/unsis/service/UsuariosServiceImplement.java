package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.UsuarioDAO;
import mx.edu.unsis.model.Usuarios;

//TODO: Auto-generated Javadoc
/**
* 	
* clase que implementa el servicio de los métodos para la coneccion con la base de datos
*
* @author: Vicente Mendoza
* @version: 26/03/2017
*/

public class UsuariosServiceImplement implements UsuariosService{
	
	@Autowired
	private UsuarioDAO u;
	
	@Override
	public boolean insertUsuario(Usuarios u) {
		return this.u.insertUsuario(u);
	}

	@Override
	public boolean updateUsuario(Usuarios u) {
		return this.u.updateUsuario(u);
	}

	@Override
	public List<Usuarios> getAllUsers() {
		return this.u.getAllUsers();
	}

	@Override
	public Usuarios getUsuarioById(String id) {
		return this.getUsuarioById(id);
	}

	@Override
	public Usuarios loginUser(String userName, String password, int usuarioTipo) {
		return this.u.loginUser(userName, password, usuarioTipo);
	}

}
