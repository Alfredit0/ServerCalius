package mx.edu.unsis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.edu.unsis.model.Users;

public class UserMapper implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users obj =new Users();
		obj.setUser_id(rs.getString("id_usuario"));
		obj.setUser_pass(rs.getString("u_password"));
		return obj;
	}

}
