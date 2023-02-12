package com.example.demoRESTweb.controller;

import com.example.demoRESTweb.entity.Address;
import com.example.demoRESTweb.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address newAddress = addressService.saveAddress(address);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(address.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

    @GetMapping("/allAdresses")
    public ResponseEntity<List> getData() {
        List<Address> addressesList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok().build();
    }

    /*
    Class ServletUriComponentsBuilder:
        UriComponentsBuilder with additional static factory methods to create links based on the current HttpServletRequest.
    method buildAndExpand():
        Build a UriComponents instance and replaces URI template variables with the values from an array. This is a shortcut method which combines calls to build() and then UriComponents.expand(Object...)
     */
}
