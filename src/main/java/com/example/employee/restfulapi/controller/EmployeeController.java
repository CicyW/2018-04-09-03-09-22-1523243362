package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @GetMapping(value = "{id}")
    Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping(value = "/page/{number}/pageSize/{size}")
    Page<Employee> getPageEmployeeList(@PathVariable int number,@PathVariable int size){
        Sort sort =  new Sort(Sort.Direction.DESC, "id");
        return employeeService.getPageEmployeeList(new PageRequest(number, size, sort));
    }

    @GetMapping(value = "/gender/{gender}")
    List<Employee> getEmployeeListByGender(@PathVariable String gender){
        return  employeeService.getEmployeeListByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestParam(required = false) Long companyId,
                            @RequestBody Employee employee) throws Exception {
        return employeeService.saveEmployee(employee,companyId);
    }

    @PutMapping(value = "{id}")
    Integer updateEmployee(@PathVariable Long id,@RequestBody Employee employee)throws Exception{
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping(value = "{id}")
    Integer deleteEmployee(@PathVariable Long id) throws Exception{
        return employeeService.deleteEmployee(id);
    }
}
