package com.geekster.MappingPractice.repo;

import com.geekster.MappingPractice.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, String> {
}
