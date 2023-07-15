package com.geekster.MappingPractice.controller;

import com.geekster.MappingPractice.models.Address;
import com.geekster.MappingPractice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }
}
