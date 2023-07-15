package com.geekster.MappingPractice.repo;

import com.geekster.MappingPractice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
