package org.example.kafkaredisspring.domain.payment.producer;

import static org.example.kafkaredisspring.common.model.kafka.topic.KafkaTopics.TOPIC_PAYMENT_COMPLETED;

import lombok.RequiredArgsConstructor;
import org.example.kafkaredisspring.common.model.kafka.event.PaymentCompletedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentCompletedEvent> paymentCompletedEventKafkaTemplate;

    public void send(PaymentCompletedEvent event) {
		String key = event.getUserId().toString(); //같은 유저의 이벤트는 같은 파티션에 저장되도록한다
        paymentCompletedEventKafkaTemplate.send(TOPIC_PAYMENT_COMPLETED,key, event);
    }

}
