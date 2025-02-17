package employee_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

	// Add Employee
	@Override
	public void addEmployee(Employee employee) 
	{
		Connection con = null;
		
		String insertQuery = "INSERT INTO Employee (name, age, department_id) VALUES(?, ?, (SELECT id FROM Department WHERE name = ?))";

		try 
		{
			con = DatabaseConnection.createConnection();

			PreparedStatement stmt = con.prepareStatement(insertQuery);

			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getAge());
			stmt.setString(3, employee.getDepartment());

			int rowsInserted = stmt.executeUpdate();
			
			if(rowsInserted>0)
			{
				System.out.println("\nEmployee added successfully");

			} 
			else 
			{
				System.out.println("\nDepartment not found");

			}

			// connection close
			con.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Update or Create Employee by Primary Key
	@Override
	public void updateEmployeeByPrimaryKey(Employee employee) 
	{
		Connection con = null;
		String checkQuery = "SELECT id FROM Employee WHERE id = ?";
		String updateQuery = "UPDATE Employee SET name=? , age=?, department_id= (SELECT id FROM Department WHERE name = ?) WHERE id= ?";
		String insertQuery = "INSERT INTO Employee (name, age, department_id) VALUES(?, ?, (SELECT id FROM Department WHERE name = ?))";

		try {
			con = DatabaseConnection.createConnection();
			
			// check if employee exists
			PreparedStatement checkStmt = con.prepareStatement(checkQuery);

			checkStmt.setInt(1, employee.getId());
			ResultSet rs = checkStmt.executeQuery();
		


			if (rs.next()) 
			{
				PreparedStatement updateStmt = con.prepareStatement(updateQuery);
				updateStmt.setString(1, employee.getName());
				updateStmt.setInt(2, employee.getAge());
				updateStmt.setString(3, employee.getDepartment());
				updateStmt.setInt(4, employee.getId());

				int rowsUpdated = updateStmt.executeUpdate();
				if(rowsUpdated>0)
				{
					System.out.println("\nEmployee updated successfully");

				}
				else 
				{
					System.out.println("\nDeptartment not found");
				}
			}

			else 
			{
				PreparedStatement insertStmt = con.prepareStatement(insertQuery);
				
				insertStmt.setString(1, employee.getName());
				insertStmt.setInt(2, employee.getAge());
				insertStmt.setString(3, employee.getDepartment());

				int rowsInserted = insertStmt.executeUpdate();
				if(rowsInserted>0)
				{
				System.out.println("\nEmployee not found, New Employee added");

				}
				else 
				{
					System.out.println("\nDeptartment not found");
				}
			} 
			

			// connection close
			con.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	// Delete Employee 
	@Override
	public void deleteEmployeeByPrimaryKey(int id) {
		Connection c = null;
		String deleteQuery = "DELETE FROM Employee where id=?";

		try {
			c = DatabaseConnection.createConnection();
			PreparedStatement stmt = c.prepareStatement(deleteQuery);

			stmt.setInt(1, id);

			int rowDeleted = stmt.executeUpdate();
			
			if (rowDeleted > 0) {
				System.out.println("\nRecord deleted ");
			} 
			else {
				System.out.println("\nEmployee Not found");
			}

			// connection close
			c.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Get Employee by Primary Key
	@Override
	public void getEmployeeByPrimaryKey(int id) {
		Connection c = null;

		String selectQuery = "SELECT e.id, e.name, e.age, d.name AS department FROM Employee e JOIN Department d ON e.department_id = d.id Where e.id = ?";

		try {
			c = DatabaseConnection.createConnection();
			PreparedStatement st = c.prepareStatement(selectQuery);

			// set data
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Age: " + rs.getInt("age"));
				System.out.println("Department: " + rs.getString("department"));

			}

			else {
				System.out.println("\nEmployee Not found");
			}

			// connection close
			c.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
