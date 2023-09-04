package org.hakanbh.service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hakanbh.model.Employee;
import org.hakanbh.model.dto.CreateEmployeeRequest;
import org.hakanbh.model.dto.UpdateEmployeeRequest;
import org.hakanbh.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee create(CreateEmployeeRequest request) {
        Employee employee = new Employee(null, request.getFirstName(), request.getLastName(), request.getDepartment());
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, UpdateEmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw HttpClientErrorException.create(HttpStatus.NOT_FOUND, "", null, new byte[] {},
                                                  StandardCharsets.UTF_8);
        }

        Employee entity = employee.get();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDepartment(request.getDepartment());
        return employeeRepository.save(entity);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
