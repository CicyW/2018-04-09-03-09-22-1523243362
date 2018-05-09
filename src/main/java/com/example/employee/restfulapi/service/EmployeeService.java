package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    Employee getEmployee(Long id);
    Page<Employee> getPageEmployeeList(Pageable pageable);
    List<Employee> getEmployeeListByGender(String gender);
    Employee saveEmployee(Employee employee,Long companyId)throws Exception;
    Integer updateEmployee(Long id,Employee employee)throws Exception;
    Integer deleteEmployee(Long id)throws Exception;

}
