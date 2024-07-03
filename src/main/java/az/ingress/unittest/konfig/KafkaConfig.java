package az.ingress.unittest.konfig;


import lombok.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
   // @Value("${topicName")
    private String topicName="newTopic";

    @Bean
    public NewTopic ms22() {
        return TopicBuilder.name("ms22")
                .partitions(3)
                .replicas(1)
                .build();
    }

}
