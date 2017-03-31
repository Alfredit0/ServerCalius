package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.UsuariosTempDAO;
import mx.edu.unsis.model.UsuariosTemp;

public class UsuariosTempServiceImplement implements UsuariosTempService{
	
	@Autowired
	private UsuariosTempDAO u;
	
	@Override
	public boolean insertUsuarioTemp(UsuariosTemp u) {
		return this.u.insertUsuarioTemp(u);
	}

	@Override
	public boolean updateUsuariosTemp(UsuariosTemp u) {
		return this.u.updateUsuariosTemp(u);
	}

	@Override
	public boolean eliminarUsuarioTemp(String usuarioId) {
		return this.u.eliminarUsuarioTemp(usuarioId);
	}

	@Override
	public List<UsuariosTemp> getAllUsers() {
		return this.u.getAllUsers();
	}

	@Override
	public UsuariosTemp getUsuarioTempById(String id) {
		return this.u.getUsuarioTempById(id);
	}

	@Override
	public boolean verificarCodigoUsuario(String usuarioId, String code) {
		return this.u.verificarCodigoUsuario(usuarioId, code);
	}

}
