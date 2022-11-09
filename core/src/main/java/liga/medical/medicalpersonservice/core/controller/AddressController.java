package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.model.Contact;
import liga.medical.medicalpersonservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
@Api(value = "API для работы с адресами")
public class AddressController {

    private final AddressService addressService;

    @ApiOperation(value = "Получение всех адресов")
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @ApiOperation(value = "Получение адреса по id")
    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable long addressId) {
        return addressService.getAddressById(addressId);
    }

    @ApiOperation(value = "Получение адреса по id контакта")
    @GetMapping("contacts/{contactId}")
    public Address getAddressByContactId(@PathVariable long contactId) {
        return addressService.getAddressByContactId(contactId);
    }

    @ApiOperation(value = "Создание адреса")
    @PostMapping
    public void insertAddress(@RequestBody Address address) {
        addressService.insertAddress(address);
    }

    @ApiOperation(value = "Обновление адреса")
    @PatchMapping("/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody Address address) {
        addressService.updateContact(id, address);
    }

}
