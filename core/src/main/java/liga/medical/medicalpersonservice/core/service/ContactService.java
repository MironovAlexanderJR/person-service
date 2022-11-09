package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.Contact;
import liga.medical.medicalpersonservice.core.model.dto.ContactDto;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getById(long id);

    void updateContact(long id, Contact contact);
}
