package com.example.employee.restfulapi.serviceImpl;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import com.example.employee.restfulapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findAllByIdNotNull();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Set<Employee> getEmployeeSet(Long id) {
        return companyRepository.findEmployeeSetById(id);
    }

    @Override
    public Page<Company> getPageCompanyList(Pageable pageable) {
        return companyRepository.findCompanyByPage(pageable);
    }

    @Override
    public Company saveCompany(Company company) throws Exception {
        return companyRepository.save(company);
    }

    @Override
    public Integer updateCompany(Long id,Company company) throws Exception {
        return companyRepository.updateCompany(id,company.getCompanyName(),company.getEmployeesNumber());
    }

    @Override
    public Integer deleteCompany(Long id) throws Exception {
        return companyRepository.deleteCompany(id);
    }
}
