package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByIdNotNull();

    Company findById(Long id);

    @Query(value = "select c.employees from Company c where c.id =?1")
    Set<Employee> findEmployeeSetById(Long id);

    @Query(value = "select c.id,c.companyName,c.employeesNumber from Company c", countQuery = "select count(c) from Company c")
    Page<Company> findCompanyByPage(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update Company c set c.companyName =?2,c.employeesNumber=?3 where c.id=?1")
    Integer updateCompany(Long id,String companyName,Integer employeesNumber);

    @Transactional
    @Modifying
    @Query(value = "delete from Company c where c.id=?1")
    Integer deleteCompany(Long id);
}
