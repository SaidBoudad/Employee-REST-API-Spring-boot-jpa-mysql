package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//            return employee.get();
//        }
//        else {
//            throw new ResourceNotFoundException("employee","Id",id);
//        }
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee,Long id) {
        employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
//        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
//        existingEmployee.setFirstName(employee.getFirstName());
//        existingEmployee.setLastName(employee.getLastName());
//        existingEmployee.setEmail(employee.getEmail());
//        employeeRepository.save(existingEmployee);
//        return existingEmployee;
        if (employeeRepository.existsById(id)){
            employee.setId(id);
            employeeRepository.save(employee);
        }return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        employeeRepository.deleteById(id);
    }



}
