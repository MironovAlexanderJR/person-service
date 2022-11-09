package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.SignalMapper;
import liga.medical.medicalpersonservice.core.model.Signal;
import liga.medical.medicalpersonservice.core.repository.SignalRepository;
import liga.medical.medicalpersonservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignalServiceImpl implements SignalService {

    private final SignalRepository signalRepository;
    private final SignalMapper signalMapper;


    @Override
    public List<Signal> getAllSignals() {
        return signalRepository.findAll();
    }

    @Override
    public Signal getById(Long id) {
        return signalRepository.findById(id).get();
    }

    @Override
    public void saveSignal(Signal signal) {
        signalRepository.save(signal);
    }

    @Override
    public void updateSignal(Long id, Signal signal) {
        Optional.of(id)
                .map(this::getById)
                .map(current -> signalMapper.merge(current, signal))
                .map(signalRepository::save)
                .orElseThrow();
    }


}
