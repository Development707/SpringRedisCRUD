package com.example.springredis.controller;

import com.example.springredis.model.Employee;
import com.example.springredis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class RedisController {
    @Autowired
    private RedisRepository redisRepository;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        redisRepository.saveEmployee(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> findAll() {
        return redisRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        return redisRepository.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {

        redisRepository.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        redisRepository.delete(id);
    }
}
