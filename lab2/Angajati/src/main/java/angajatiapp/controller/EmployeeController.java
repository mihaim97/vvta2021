package angajatiapp.controller;

import java.util.List;

import angajatiapp.model.Employee;
import angajatiapp.repository.EmployeeRepositoryInterface;
import angajatiapp.view.EmployeeView;

public class EmployeeController {
	
	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeView employeeView;
	
	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		this.employeeView = new EmployeeView();
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}
	
	public void modifyEmployee(Employee oldEmployee, DidacticFunction newFunction) {
		employeeRepository.modifyEmployeeFunction(oldEmployee, newFunction);
	}
	
	public List<Employee> getSortedEmployeeList() {
		return employeeRepository.getEmployeeByCriteria();
	}
	
	public void printMenu() {
		employeeView.printMenu();
	}

	public Employee findEmployeeById(int idOldEmployee) {
		return employeeRepository.findEmployeeById(idOldEmployee);
	}

}
