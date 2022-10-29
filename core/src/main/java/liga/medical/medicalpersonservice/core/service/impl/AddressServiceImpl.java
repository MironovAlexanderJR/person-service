package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import liga.medical.medicalpersonservice.core.mapper.AddressMapper;
import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddresses() {
        return addressMapper.getAllAddresses();
    }

    @Override
    public Address getAddressById(long id) {
        return addressMapper.getAddressById(id);
    }

    @Override
    public Address getAddressByContactId(long contactId) {
        return addressMapper.getAddressByContactId(contactId);
    }

    @Override
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }
}
