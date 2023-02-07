package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import utils.connection.SingleConnection;

public class LoginDao {
	
	private Connection connection;
	
	public LoginDao() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validateLogin(LoginModel loginModel) {

		String sql = """
				SELECT
					username, password
				FROM
					public.login
				WHERE 
					username = ? AND password = ?;
				""";
		
		try {
			var statement = connection.prepareStatement(sql);

			statement.setString(1, loginModel.getUsername());
			statement.setString(2, loginModel.getPassword());
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				return Boolean.TRUE;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
		return Boolean.FALSE;
	}
	
}
