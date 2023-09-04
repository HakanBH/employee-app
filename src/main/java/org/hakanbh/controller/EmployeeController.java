package org.hakanbh.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hakanbh.model.Employee;
import org.hakanbh.model.dto.CreateEmployeeRequest;
import org.hakanbh.model.dto.UpdateEmployeeRequest;
import org.hakanbh.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody CreateEmployeeRequest request) {
        return employeeService.create(request);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        return employeeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
