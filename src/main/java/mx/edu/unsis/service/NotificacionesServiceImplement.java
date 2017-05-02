package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.NotificacionesDAO;
import mx.edu.unsis.model.Notificaciones;

public class NotificacionesServiceImplement implements NotificacionesService{
	@Autowired
	private NotificacionesDAO n;
	
	@Override
	public boolean insertNotificaciones(Notificaciones a) {
		// TODO Auto-generated method stub
		return this.n.insertNotificaciones(a);
	}

	@Override
	public boolean updateNotificaciones(Notificaciones a) {
		// TODO Auto-generated method stub
		return this.n.updateNotificaciones(a);
	}

	@Override
	public boolean eliminarNotificacion(int idNotificacion) {
		// TODO Auto-generated method stub
		return this.n.eliminarNotificacion(idNotificacion);
	}

	@Override
	public Notificaciones getNotificacionById(int idNotificacion) {
		// TODO Auto-generated method stub
		return this.n.getNotificacionById(idNotificacion);
	}

	@Override
	public List<Notificaciones> getAllNotificaciones() {
		// TODO Auto-generated method stub
		return this.n.getAllNotificaciones();
	}

}
