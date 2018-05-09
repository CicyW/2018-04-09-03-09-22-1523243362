package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByIdNotNull();

    Employee findById(Long id);

    List<Employee> findByGender(String gender);

    @Query(value = "select e.id,e.age,e.gender,e.name,e.salary from Employee e", countQuery = "select count(e) from Employee e")
    Page<Employee> findEmployeeByPage(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.name=?2,e.age=?3,e.gender=?4,e.salary=?5 where e.id=?1")
    Integer updateEmployee(Long id,String name,Integer age,String gender,Integer salary);

    @Transactional
    @Modifying
    @Query(value = "delete from Employee e where e.id=?1")
    Integer deleteEmployee(Long id);
}
