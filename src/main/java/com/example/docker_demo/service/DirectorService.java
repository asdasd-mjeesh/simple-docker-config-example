package com.example.docker_demo.service;

import com.example.docker_demo.entity.Director;
import com.example.docker_demo.repository.DirectorRepository;
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
public class DirectorService {

    @Value("${page.size}")
    private Integer pageSize;
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director saveOrUpdate(Director director) {
        return directorRepository.save(director);
    }

    public Optional<Director> findById(Long id) {
        return directorRepository.findById(id);
    }

    public List<Director> findAllOnPage(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.unsorted());
        Page<Director> queryResult = directorRepository.findAll(pageable);

        if (queryResult.hasContent()) {
            return queryResult.getContent();
        }
        return new ArrayList<>();
    }

    public void deleteById(Long id) {
        directorRepository.deleteById(id);
    }
}
