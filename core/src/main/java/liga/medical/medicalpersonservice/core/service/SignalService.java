package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.model.Signal;

public interface SignalService {

    List<Signal> getAllSignals();

    Signal getById(Long id);

    void saveSignal(Signal signal);

    void updateSignal(Long id, Signal signal);
}
