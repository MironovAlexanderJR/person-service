package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.Illness;

public interface IllnessService {
    List<Illness> getAllIllnesses();

    Illness getById(Long id);

    void updateIllness(Long id, Illness illness);
}
