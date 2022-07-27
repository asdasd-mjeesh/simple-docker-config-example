package com.example.docker_demo.rest;

import com.example.docker_demo.dto.DirectorDto;
import com.example.docker_demo.entity.Director;
import com.example.docker_demo.mapper.DirectorMapper;
import com.example.docker_demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorControllerV1 {

    private final DirectorService directorService;
    private final DirectorMapper directorMapper;

    @Autowired
    public DirectorControllerV1(DirectorService directorService, DirectorMapper directorMapper) {
        this.directorService = directorService;
        this.directorMapper = directorMapper;
    }

    @PostMapping("/")
    public DirectorDto saveOrUpdate(@RequestBody Director director) {
        Director result = directorService.saveOrUpdate(director);
        return directorMapper.map(result);
    }

    @GetMapping("/{id}")
    public DirectorDto findById(@PathVariable(name = "id") Long id) {
        Optional<Director> result = directorService.findById(id);
        return directorMapper.map(result.orElse(new Director()));
    }

    @GetMapping("/")
    public List<DirectorDto> findAllOnPage(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Director> result = directorService.findAllOnPage(pageNo);
        return directorMapper.map(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        directorService.deleteById(id);
    }
}
