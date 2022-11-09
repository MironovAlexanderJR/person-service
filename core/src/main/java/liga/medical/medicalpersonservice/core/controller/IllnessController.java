package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import java.util.List;
import liga.medical.medicalpersonservice.core.model.Illness;
import liga.medical.medicalpersonservice.core.service.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/illnesses")
@Api(value = "API для работы с болезнями")
public class IllnessController {

    private final IllnessService illnessService;

    @GetMapping
    public List<Illness> getAllIllnesses() {
        return illnessService.getAllIllnesses();
    }

    @GetMapping("/{id}")
    public Illness getById(@PathVariable Long id) {
        return illnessService.getById(id);
    }

    @PatchMapping("/{id}")
    public void updateIllness(@PathVariable Long id, @RequestBody Illness illness) {
        illnessService.updateIllness(id, illness);
    }
}
