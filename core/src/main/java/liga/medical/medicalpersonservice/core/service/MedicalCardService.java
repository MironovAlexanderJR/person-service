package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.MedicalCard;

public interface MedicalCardService {
    List<MedicalCard> getAllMedicalCards();

    MedicalCard getById(Long id);

    void updateMedicalCard(Long id, MedicalCard medicalCard);
}
