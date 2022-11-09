package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.IllnessMapper;
import liga.medical.medicalpersonservice.core.model.Illness;
import liga.medical.medicalpersonservice.core.repository.IllnessRepository;
import liga.medical.medicalpersonservice.core.service.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IllnessServiceImpl implements IllnessService {

    private final IllnessRepository illnessRepository;
    private final IllnessMapper illnessMapper;

    @Override
    public List<Illness> getAllIllnesses() {
        return illnessRepository.findAll();
    }

    @Override
    public Illness getById(Long id) {
        return illnessRepository.findById(id).get();
    }

    @Override
    public void updateIllness(Long id, Illness illness) {
        Optional.of(id)
                .map(this::getById)
                .map(current -> illnessMapper.merge(current, illness))
                .map(illnessRepository::save)
                .orElseThrow();
    }
}
