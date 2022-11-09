package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.MedicalCard;
import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.service.MedicalCardService;
import liga.medical.medicalpersonservice.core.service.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person-dates")
@Api(value = "API для работы с данными пользователя")
public class PersonDataController {

    private final PersonDataService personDataService;

    @GetMapping
    public List<PersonData> getAllPersonDates() {
        return personDataService.getAllPersonDates();
    }

    @GetMapping("/{id}")
    public PersonData getById(@PathVariable Long id) {
        return personDataService.getById(id);
    }

    @PatchMapping("/{id}")
    public void updateMedicalCard(@PathVariable Long id, @RequestBody PersonData personData) {
        personDataService.updatePersonDates(id, personData);
    }
}
