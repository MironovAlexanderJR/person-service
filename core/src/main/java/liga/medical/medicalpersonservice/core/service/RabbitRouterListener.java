package liga.medical.medicalpersonservice.core.service;

public interface RabbitRouterListener {

    void receivingAndDistributingMessages(String message);
}
