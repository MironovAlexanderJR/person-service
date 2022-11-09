package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.Illness;
import liga.medical.medicalpersonservice.core.model.MedicalCard;
import liga.medical.medicalpersonservice.core.service.IllnessService;
import liga.medical.medicalpersonservice.core.service.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medical-cards")
@Api(value = "API для работы с медицинскими картами")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    @GetMapping
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.getAllMedicalCards();
    }

    @GetMapping("/{id}")
    public MedicalCard getById(@PathVariable Long id) {
        return medicalCardService.getById(id);
    }

    @PatchMapping("/{id}")
    public void updateMedicalCard(@PathVariable Long id, @RequestBody MedicalCard medicalCard) {
        medicalCardService.updateMedicalCard(id, medicalCard);
    }
}
