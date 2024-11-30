package az.ingress.unittest.service;

import az.ingress.unittest.dto.Transfer;
import az.ingress.unittest.repository.TranferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j

public class TransferService {

    private final TranferRepository repository;

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${topic.name}")
    private String topicName;


    public String producesString(String name) {
        Transfer transfer = Transfer.builder()
                .name(name)
                .balance(500.0)
                .build();
        try {

            CompletableFuture<SendResult<String, Object >> sendResult =
                    kafkaTemplate.send(topicName,"key",transfer);

              sendResult.whenComplete((result, ex) -> {

                if (ex == null) {
                    log.info("Data successfully sending to kafka");
                } else {
                    log.error("There occur error");
                }
            });

        } catch (Exception e) {
            log.info("Exception is -- {}", e.getMessage());
        }

        return "OK";
    }

    public Transfer getTranfer(Long id) {

         return repository.findById(id).orElseThrow();
    }

    public Transfer postTranfer(Transfer transfer) {
        return repository.save(transfer);
    }



}
