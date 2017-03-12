package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import mx.edu.unsis.model.Users;


public interface UsersDAO {
	public void setDataSource(DataSource dataSource);
	void insertUser(Users user);
	List<Users> getAllUsers();
	Users getUserById(String id);
	Users loginUser(String userName, String password);
}
