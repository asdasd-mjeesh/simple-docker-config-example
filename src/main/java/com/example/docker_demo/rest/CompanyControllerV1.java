package com.example.docker_demo.rest;

import com.example.docker_demo.dto.CompanyDto;
import com.example.docker_demo.entity.Company;
import com.example.docker_demo.mapper.CompanyMapper;
import com.example.docker_demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyControllerV1 {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyControllerV1(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @PostMapping("/")
    public CompanyDto saveOrUpdate(@RequestBody Company company) {
        Company result = companyService.saveOrUpdate(company);
        return companyMapper.map(result);
    }

    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable(name = "id") Long id) {
        Optional<Company> result = companyService.findById(id);
        return companyMapper.map(result.orElse(new Company()));
    }

    @GetMapping("/")
    public List<CompanyDto> findAllOnPage(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Company> result = companyService.getAllOnPage(pageNo);
        return companyMapper.map(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        companyService.deleteById(id);
    }
}
