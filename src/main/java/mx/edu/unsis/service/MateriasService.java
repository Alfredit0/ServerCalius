package mx.edu.unsis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.unsis.model.Materias;
/**
 * 	
 * clase que implementa el servicio de los métodos para la coneccion con la base de datos de la tabla materias.
 *
 * @author: Vicente Mendoza
 * @version: 28/03/2017
 */
@Service
public interface MateriasService {
	/**
	 * Insert Materia.
	 *
	 * @param a el objeto materia a insertar
	 */
	public void insertMateria(Materias a);
	
	/**
	 * Update materia.
	 *
	 * @param a el objeto materia a actualizar
	 */
	public void updateMaterias(Materias a);
	
	/**
	 * Eliminar Materia.
	 *
	 * @param materiaId el id de la materia a eliminar
	 * @return true, si la materia se elimino correctamente, false en caso contrario
	 */
	public boolean eliminarMateria(String materiaId);
	
	/**
	 * obtiene una materia por su Id
	 *
	 * @param materiaId el Id de la materia que se desea buscar
	 * @return el objeto materia que fue buscado, null en caso de que no se encuentra en la BD
	 */
	public Materias getMateriaById(String materiaId);
	
	/**
	 * Obtiene todas las materias dados de alta en la base de datos
	 *
	 * @return todos las materias existentes en la base de datos
	 */
	public List<Materias> getAllMaterias();
}
