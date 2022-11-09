package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.Contact;
import liga.medical.medicalpersonservice.core.model.dto.ContactDto;
import liga.medical.medicalpersonservice.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contacts")
@Api(value = "API для работы с контактами")
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable Long id) {
        return contactService.getById(id);
    }

    @PatchMapping("/{id}")
    public void updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contactService.updateContact(id, contact);
    }
}
