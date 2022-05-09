package com.zensar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;
import com.zensar.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return repository.findById(id).get();

	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		Employee employee = repository.findById(id).get();
		employee.setFirstName(newEmployee.getFirstName());
		employee.setLastName(newEmployee.getLastName());
		employee.setEmailId(newEmployee.getEmailId());
		employee.setDepartment(newEmployee.getDepartment());
		repository.save(employee);

	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {

		repository.deleteById(id);
	}

}
