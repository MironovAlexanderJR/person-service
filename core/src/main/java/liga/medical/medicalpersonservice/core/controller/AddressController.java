package liga.medical.medicalpersonservice.core.controller;

import java.math.BigInteger;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable long addressId) {
        return addressService.getAddressById(addressId);
    }

    @GetMapping("{/contactId}")
    public Address getAddressByContactId(@PathVariable long contactId) {
        return addressService.getAddressByContactId(contactId);
    }

    @PostMapping
    public void insertAddress(@RequestBody Address address) {
        addressService.insertAddress(address);
    }

}
