package admin.domain.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Consumer {


    @RabbitListener(queues = "test.queue")
    public void TestConsumer(
            String message
    ){
        log.info("message queue >> {}", message);
    }
}
