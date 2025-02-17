package employee_app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
	
		Scanner sc = new Scanner(System.in);
		
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		
		char ch;
		
		do 
		{
			System.out.println("\n ========  Employee Management System  ========= \n");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Get Employee");
			System.out.println("5. Exit\n");
			
			System.out.println("Enter your choice: ");
			ch = sc.next().charAt(0);
			
			
			switch(ch)
			{
				case '1':
					
					System.out.println("Enter Name : ");
					String name = sc.next();
					
					System.out.println("Enter Age : ");
					int age = sc.nextInt();
					
					System.out.println("Enter Department name : ");
					String dept = sc.next();
					
					employeeDAO.addEmployee(new Employee(name, age, dept));
					
					break;
					
					
				case '2':
					
					System.out.println("Enter ID to Update : ");
					int idToUpdate = sc.nextInt();
					
					System.out.println("Enter Name : ");
					String newName = sc.next();
					
					System.out.println("Enter Age : ");
					int newAge = sc.nextInt();
					
					System.out.println("Enter Department name : ");
					String newDept = sc.next();
					
					employeeDAO.updateEmployeeByPrimaryKey(new Employee(idToUpdate, newName, newAge, newDept));
					
					break;
					
				
				case '3':
					
					System.out.println("Enter ID to Delete : ");
					int idToDelete = sc.nextInt();
					
					employeeDAO.deleteEmployeeByPrimaryKey(idToDelete);
					
					break;
					
					
				case '4':
					System.out.println("Enter ID to view ");
					int idToView = sc.nextInt();
					
					employeeDAO.getEmployeeByPrimaryKey(idToView);
					
					break;
					
					
				case '5':
					System.out.println("Exiting the program.\n");
		            //System.exit(0);
		            break;
					
				default:
					System.out.println("Invalid choice! Please try again\n");
		            
					
			}
				
			
		}while(ch != '5');
		
		sc.close();
	}

}
