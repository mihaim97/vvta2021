package angajatiapp.repository;

import angajatiapp.controller.DidacticFunction;
import angajatiapp.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeMockTest {

    private static EmployeeMock employeeMock;

    @BeforeAll
    private static void init(){
        employeeMock = new EmployeeMock();
    }

    @ParameterizedTest
    @MethodSource("employeeListAsStreamExpectedTrue")
    void addEmployeeExpectedTrue(Employee employee) {
        assertEquals(true, employeeMock.addEmployee(employee));
    }

    @ParameterizedTest
    @MethodSource("employeeListAsStreamExpectedFalse")
    void addEmployeeExpectedFalse(Employee employee) {
        assertEquals(false, employeeMock.addEmployee(employee));
    }

    public static Stream<Employee> employeeListAsStreamExpectedTrue() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 1500.0);
        Employee emp2 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 1.0);
        Employee emp3 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 2.0);
        Employee emp4 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 2500.0);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        return employeeList.stream();
    }

    public static Stream<Employee> employeeListAsStreamExpectedFalse() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee("1Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 4500.0);
        Employee emp2 = new Employee("Ana", "1Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 1500.0);
        Employee emp3 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, 0.0);
        Employee emp4 = new Employee("Ana", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, -1.0);
        Employee emp5 = new Employee("A", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, -1.0);
        Employee emp6 = new Employee(null, "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, -1.0);
        Employee emp7 = new Employee("An", "Iulia", "1970437890857",
                DidacticFunction.ASISTENT, -1.0);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        return employeeList.stream();
    }
}