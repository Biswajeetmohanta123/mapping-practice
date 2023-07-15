package com.geekster.MappingPractice.controller;

import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.repo.LaptopRepository;
import com.geekster.MappingPractice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable String id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping("/")
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable String id, @RequestBody Laptop laptop) {
       return laptopService.updateLaptop(id,laptop);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable String id) {
        laptopService.deleteLaptop(id);
    }
}

