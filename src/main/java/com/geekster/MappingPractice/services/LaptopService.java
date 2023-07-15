package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.exception.ResourceNotFoundException;
import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(String id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop not found"));
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(String id, Laptop laptop) {
        Laptop existingLaptop = laptopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop not exist"));
        existingLaptop.setName(laptop.getName());
        existingLaptop.setBrand(laptop.getBrand());
        existingLaptop.setPrice(laptop.getPrice());
        existingLaptop.setStudent(laptop.getStudent());
        return laptopRepository.save(existingLaptop);
    }

    public void deleteLaptop(String id) {
        Laptop existingLaptop = laptopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop not exist"));
        laptopRepository.delete(existingLaptop);
    }
}
