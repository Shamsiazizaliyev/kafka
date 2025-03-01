package az.ingress.unittest.konfig;



import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Value("${topic.name}")
    private String topicName;

    @Bean
    public NewTopic ms22() {
        return TopicBuilder.name(topicName)
                .partitions(3)
                .replicas(1)
                .build();

    }
}
