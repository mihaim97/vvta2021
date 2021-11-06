package angajatiapp.validator;

import angajatiapp.model.Employee;
import angajatiapp.repository.EmployeeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidatorTest {

    private static EmployeeImpl employee;

    private static EmployeeValidator employeeValidator;

    @BeforeAll
    static void init() {
        employee = new EmployeeImpl();
        employeeValidator = new EmployeeValidator();
    }

    @ParameterizedTest
    @MethodSource("employeeAsStream")
    void testIsSalaryValid(Employee employee) {
        assertEquals(true, employeeValidator.isValid(employee));
    }

    static Stream<Employee> employeeAsStream() {
        return employee.getEmployeeList().stream();
    }

}