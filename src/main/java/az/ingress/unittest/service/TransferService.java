package az.ingress.unittest.service;

import az.ingress.unittest.dto.Transfer;
import az.ingress.unittest.repository.TranferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TranferRepository repository;

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public String producesString(String name) {

        Transfer transfer=new Transfer();
        // kafkaTemplate.send("ms22",1,"name",name);
        kafkaTemplate.send("ms22","1234",name);


        return "ok";
    }
    public Transfer getTranfer(Long id) {

         return repository.findById(id).orElseThrow();
    }

    public Transfer postTranfer(Transfer transfer) {
        return repository.save(transfer);
    }



}
