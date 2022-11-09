package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.MedicalCardMapper;
import liga.medical.medicalpersonservice.core.model.MedicalCard;
import liga.medical.medicalpersonservice.core.repository.MedicalCardRepository;
import liga.medical.medicalpersonservice.core.service.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;
    private final MedicalCardMapper medicalCardMapper;

    @Override
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardRepository.findAll();
    }

    @Override
    public MedicalCard getById(Long id) {
        return medicalCardRepository.findById(id).get();
    }

    @Override
    public void updateMedicalCard(Long id, MedicalCard medicalCard) {
        Optional.of(id)
                .map(this::getById)
                .map(current -> medicalCardMapper.merge(current, medicalCard))
                .map(medicalCardRepository::save)
                .orElseThrow();
    }
}
