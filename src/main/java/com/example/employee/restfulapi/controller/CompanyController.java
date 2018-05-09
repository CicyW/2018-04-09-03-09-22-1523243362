package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    //在此处完成Company API

    @GetMapping
    List<Company> getCompanys(){
        return companyService.getCompanyList();
    }

    @GetMapping(value = "{id}")
    Company getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @GetMapping(value = "/page/{number}/pageSize/{size}")
    Page<Company> getPageCompanys(@PathVariable int number,@PathVariable int size){
        Sort sort =  new Sort(Sort.Direction.DESC, "id");
        return companyService.getPageCompanyList(new PageRequest(number, size, sort));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Company createEmployee(@RequestBody Company company) throws Exception {
        return companyService.saveCompany(company);
    }

    @PutMapping(value = "{id}")
    Integer updateCompany(@PathVariable Long id,@RequestBody Company company)throws Exception{
        return companyService.updateCompany(id,company);
    }

    @DeleteMapping(value = "{id}")
    Integer deleteCompany(@PathVariable Long id)throws Exception{
        return companyService.deleteCompany(id);
    }

}
