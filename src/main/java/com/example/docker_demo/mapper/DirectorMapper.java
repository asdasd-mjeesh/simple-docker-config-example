package com.example.docker_demo.mapper;

import com.example.docker_demo.dto.DirectorDto;
import com.example.docker_demo.entity.Director;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorMapper implements Mapper<DirectorDto, Director> {

    @Override
    public DirectorDto map(Director from) {
        return new DirectorDto(
                from.getId(),
                from.getName()
        );
    }

    @Override
    public List<DirectorDto> map(List<Director> fromList) {
        return fromList.stream()
                .map(director -> new DirectorDto(
                        director.getId(),
                        director.getName()
                ))
                .collect(Collectors.toList());
    }
}
