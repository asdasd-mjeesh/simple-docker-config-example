package com.example.docker_demo.dto;

public record CompanyDto(Long id,
                         DirectorDto director,
                         String title) {
}
