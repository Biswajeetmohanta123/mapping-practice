package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.exception.ResourceNotFoundException;
import com.geekster.MappingPractice.models.Address;
import com.geekster.MappingPractice.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        existingAddress.setLandmark(address.getLandmark());
        existingAddress.setZipcode(address.getZipcode());
        existingAddress.setDistrict(address.getDistrict());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(Long id) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not exist"));
        addressRepository.delete(existingAddress);
    }
}

