package com.oit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @ParameterizedTest
    @CsvSource({"John, 50000", "Jane, 60000", "Tom, 55000"})
    public void testCreateEmployee(String name, double salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);

        Employee createdEmployee = employeeService.createEmployee(employee);
        assertNotNull(createdEmployee.getId());

        Employee retrievedEmployee = employeeService.getEmployeeById(createdEmployee.getId());
        assertEquals(name, retrievedEmployee.getName());
        assertEquals(salary, retrievedEmployee.getSalary());
    }

	private void assertEquals(double salary, double salary2) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String name, String name2) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(Long id) {
		// TODO Auto-generated method stub
		
	}

    // Other test cases for update, delete, etc.
}
