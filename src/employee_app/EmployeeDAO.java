package employee_app;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);

	public void updateEmployeeByPrimaryKey(Employee employee);

	public void deleteEmployeeByPrimaryKey(int id);

	public void getEmployeeByPrimaryKey(int id);

}
