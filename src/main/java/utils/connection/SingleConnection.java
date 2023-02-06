package utils.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class SingleConnection {
	
	private static Logger logger = Logger.getLogger(SingleConnection.class.getName());

	private static String url = "jdbc:postgresql://localhost:5432/project-jsp";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		toConnect();
	}

	private SingleConnection() {
		toConnect();
	}

	private static void toConnect() {
		try {

			if (connection == null) {

				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);

				connection.setAutoCommit(false);

				logger.info("Successfully Connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
