package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.AdministrativosDAO;
import mx.edu.unsis.model.Administrativos;

public class AdministrativosServiceImplement implements AdministrativosService{
	
	@Autowired
	private AdministrativosDAO a;

	@Override
	public boolean insertAlumno(Administrativos a) {
		return this.a.insertAdministrativo(a);
	}

	@Override
	public boolean updateAlumno(Administrativos a) {
		return this.a.updateAdministrativo(a);
	}

	@Override
	public boolean eliminarAdministrativo(String adminId) {
		return this.a.eliminarAdministrativo(adminId);
	}

	@Override
	public Administrativos getAdministrativoById(String adminId) {
		return this.a.getAdministrativoById(adminId);
	}

	@Override
	public List<Administrativos> getAllAdministrativo() {
		return this.a.getAllAdministrativo();
	}
}
