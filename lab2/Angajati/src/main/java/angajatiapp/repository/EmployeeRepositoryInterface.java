package angajatiapp.repository;

import java.util.List;

import angajatiapp.controller.DidacticFunction;
import angajatiapp.model.Employee;

public interface EmployeeRepositoryInterface {

	boolean addEmployee(Employee employee);
	void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();
	Employee findEmployeeById(int idOldEmployee);

}
