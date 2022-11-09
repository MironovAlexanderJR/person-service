package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import liga.medical.medicalpersonservice.core.mapper.ContactMapper;
import liga.medical.medicalpersonservice.core.model.Contact;
import liga.medical.medicalpersonservice.core.repository.ContactRepository;
import liga.medical.medicalpersonservice.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateContact(long id, Contact contact) {
        Optional.of(id)
                .map(this::getById)
                .map(current -> contactMapper.merge(current, contact))
                .map(contactRepository::save)
                .orElseThrow();
    }
}
