package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    List<Company> getCompanyList();
    Company getCompany(Long id);
    Set<Employee> getEmployeeSet(Long id);
    Page<Company> getPageCompanyList(Pageable pageable);
    Company saveCompany(Company company) throws Exception;
    Integer updateCompany(Long id,Company company) throws Exception;
    Integer deleteCompany(Long id) throws Exception;

}
