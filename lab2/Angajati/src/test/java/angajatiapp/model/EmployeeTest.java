package angajatiapp.model;

import angajatiapp.controller.DidacticFunction;
import angajatiapp.validator.EmployeeException;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {

    private static Employee employee;

    private static Employee employee2;

    @BeforeAll
    static void init() {
        employee = new Employee("Ana", "Maria",
                "1978974567832", DidacticFunction.ASISTENT, 2000.0);
        employee2 = new Employee();
    }

    @Test
    @Order(1)
    void testSetFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("Marius");
        assertEquals("Marius", employee.getFirstName(), "Fail to set name");
    }

    @Test
    @Order(2)
    void testGetCnp() {
        assertEquals("1978974567832", employee.getCnp());
    }

    @Test
    void testEquals() {
        Employee newEmployee = new Employee("Ana", "Maria",
                "1978974567832", DidacticFunction.ASISTENT, 2000.0);
        assertEquals(true, newEmployee.equals(this.employee));
    }

    @Test
    void testEqualsExpectedFail() {
        Employee newEmployee = new Employee("Maria", "Maria",
                "1978974567832", DidacticFunction.ASISTENT, 2000.0);
        assertEquals(false, newEmployee.equals(this.employee));
    }

    @Test
    void testGetEmployeeFromString() throws EmployeeException {
        Employee employee = Employee.getEmployeeFromString("Ionela;Ionescu;1235567890876;LECTURER;25000;2", 1);
        assertEquals(2, employee.getId());
        assertEquals("Ionela", employee.getFirstName());
        assertEquals("Ionescu", employee.getLastName());
        assertEquals("1235567890876", employee.getCnp());
        assertEquals(25000, employee.getSalary());
        assertEquals(DidacticFunction.LECTURER, employee.getFunction());
    }

    @Test
    void testGetEmployeeFromDatabase() {
        assertTimeout(Duration.ofMillis(5), ()-> {
            Thread.sleep(10);
            Employee.getEmployeeFromString("Ionela;Ionescu;1235567890876;LECTURER;25000;2", 1);
        });
    }

    @Test
    void testGetEmployeeExpectedException() throws EmployeeException {
        assertThrows(EmployeeException.class,()->
                    Employee.getEmployeeFromString("Ionela;Ionescu;1235567890876;LECTURER;2", 1));
    }

}