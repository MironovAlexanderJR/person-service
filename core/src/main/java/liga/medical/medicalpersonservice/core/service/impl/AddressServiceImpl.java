package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.AddressMapper;
import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.repository.AddressRepository;
import liga.medical.medicalpersonservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address getAddressByContactId(long contactId) {
        return addressRepository.getAddressByContactId(contactId);
    }

    @Override
    public void insertAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateContact(Long id, Address address) {
        Optional.of(id)
                .map(this::getAddressById)
                .map(current -> addressMapper.merge(current, address))
                .map(addressRepository::save)
                .orElseThrow();
    }
}
