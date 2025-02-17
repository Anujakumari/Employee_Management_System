package employee_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection createConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/employeedb";
			String user = "root";
			String password = "Anuja@6204";

			con = DriverManager.getConnection(url, user, password);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

}
