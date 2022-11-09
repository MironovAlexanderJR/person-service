package liga.medical.medicalpersonservice.core.controller;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.Signal;
import liga.medical.medicalpersonservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/signals")
public class SignalController {

    private final SignalService personDataService;

    @GetMapping
    public List<Signal> getAllSignals() {
        return personDataService.getAllSignals();
    }

    @GetMapping("/{id}")
    public Signal getById(@PathVariable Long id) {
        return personDataService.getById(id);
    }

    @PatchMapping("/{id}")
    public void updateSignal(@PathVariable Long id, @RequestBody Signal signal) {
        personDataService.updateSignal(id, signal);
    }
}
