package com.example.docker_demo.service;

import com.example.docker_demo.entity.Company;
import com.example.docker_demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Value("${page.size}")
    private Integer pageSize;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company saveOrUpdate(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public List<Company> getAllOnPage(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.unsorted());
        Page<Company> queryRequest = companyRepository.findAll(pageable);

        if (queryRequest.hasContent()) {
            return queryRequest.getContent();
        }
        return new ArrayList<>();
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
