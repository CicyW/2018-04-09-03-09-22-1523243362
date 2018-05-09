package com.example.employee.restfulapi.serviceImpl;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import com.example.employee.restfulapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAllByIdNotNull();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> getPageEmployeeList(Pageable pageable) {
        return employeeRepository.findEmployeeByPage(pageable);
    }

    @Override
    public List<Employee> getEmployeeListByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public Employee saveEmployee(Employee employee,Long companyId)throws Exception {
        Company company = companyRepository.findById(companyId);
        if(company!=null) {
            employee.setCompany(company);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Integer updateEmployee(Long id, Employee employee) throws Exception{
        return employeeRepository.updateEmployee(id,employee.getName(),employee.getAge(),employee.getGender(),employee.getSalary());
    }

    @Override
    public Integer deleteEmployee(Long id)throws Exception {
        return employeeRepository.deleteEmployee(id);
    }
}
