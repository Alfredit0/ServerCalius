package mx.edu.unsis.service;

import java.util.List;

import mx.edu.unsis.model.Users;



public interface UserService {
	void insertUser(Users user);
	List<Users> getAllUsers();
	Users getUserById(String id);
	Users loginUser(String userName, String password);
}
