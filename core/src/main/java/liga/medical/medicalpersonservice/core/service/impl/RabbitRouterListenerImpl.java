package liga.medical.medicalpersonservice.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import liga.medical.commondto.RabbitMessageDto;
import liga.medical.commondto.Type;
import liga.medical.medicalpersonservice.core.annoatations.dbLog;
import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.model.QueueNames;
import liga.medical.medicalpersonservice.core.model.Signal;
import liga.medical.medicalpersonservice.core.repository.PersonDataRepository;
import liga.medical.medicalpersonservice.core.service.RabbitRouterListener;
import liga.medical.medicalpersonservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitRouterListenerImpl implements RabbitRouterListener {

    private final ObjectMapper objectMapper;
    private final SignalService signalService;
    private final PersonDataRepository personDataRepository;

    @dbLog
    @SneakyThrows
    @RabbitListeners(value = {
            @RabbitListener(queues = QueueNames.ALERT_QUEUE),
            @RabbitListener(queues = QueueNames.DAILY_QUEUE),
            @RabbitListener(queues = QueueNames.ERROR_QUEUE)
    })
    @Override
    public void receivingAndDistributingMessages(String message) {
        RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);

        if (!rabbitMessageDto.getType().equals(Type.ERROR) &&
                personDataRepository.existsById(rabbitMessageDto.getId())) {

            Optional<PersonData> personData = personDataRepository.findById(rabbitMessageDto.getId());

            Signal signal = new Signal();
            signal.setPersonDataId(personData.get());
            signal.setDescription(rabbitMessageDto.getDescription());
            signal.setType(rabbitMessageDto.getType());

            signalService.saveSignal(signal);
        }
    }
}
