package com.credmarg.smepayments.service;

import com.credmarg.smepayments.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();


    public Employee addEmployee(Employee employee) {
        employee.setId(counter.incrementAndGet());
        employees.add(employee);

        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
