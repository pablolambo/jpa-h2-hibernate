package com.example.demoRESTweb.service;

import com.example.demoRESTweb.entity.Address;
import com.example.demoRESTweb.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    // @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

}
