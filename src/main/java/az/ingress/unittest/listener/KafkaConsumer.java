package az.ingress.unittest.listener;

import az.ingress.unittest.dto.Transfer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {




   //  @RetryableTopic(attempts = "2" )
    @KafkaListener(topics = {"ms22"}, groupId = "ms22-group-id")
    public void consumer(Transfer transfer) {
        log.info("Consumer data is : {} topic is : {} offset is : {}", transfer);

    }

    }

