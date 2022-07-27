package com.example.docker_demo.mapper;

import com.example.docker_demo.dto.CompanyDto;
import com.example.docker_demo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements Mapper<CompanyDto, Company> {

    private final DirectorMapper directorMapper;

    @Autowired
    public CompanyMapper(DirectorMapper directorMapper) {
        this.directorMapper = directorMapper;
    }

    @Override
    public CompanyDto map(Company from) {
        return new CompanyDto(
                from.getId(),
                directorMapper.map(from.getDirector()),
                from.getTitle()
        );
    }

    @Override
    public List<CompanyDto> map(List<Company> fromList) {
        return fromList.stream()
                .map(company -> new CompanyDto(
                        company.getId(),
                        directorMapper.map(company.getDirector()),
                        company.getTitle()
                ))
                .collect(Collectors.toList());
    }
}
