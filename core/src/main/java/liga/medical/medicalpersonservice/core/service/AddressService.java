package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.Address;

public interface AddressService {

    List<Address> getAllAddresses();

    Address getAddressById(long id);

    Address getAddressByContactId(long contactId);

    void insertAddress(Address address);

    void updateContact(Long id, Address address);
}
