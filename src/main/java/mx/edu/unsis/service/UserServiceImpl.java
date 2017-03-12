package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.UsersDAO;
import mx.edu.unsis.model.Users;

public class UserServiceImpl implements UserService{

	@Autowired
	private UsersDAO userDao;
	
	@Override
	public void insertUser(Users user) {
		this.userDao.insertUser(user);
		
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUsers();
	}

	@Override
	public Users getUserById(String id) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(id);
	}

	@Override
	public Users loginUser(String userName, String password) {
		// TODO Auto-generated method stub
		return this.userDao.loginUser(userName, password);
	}

}
