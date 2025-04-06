package com.buildrun.orderms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.buildrun.orderms.config.RabbitMQConfig.ORDER_CREATED_QUEUE;
import com.buildrun.orderms.listener.dto.OrderCreatedEvent;
import com.buildrun.orderms.service.OrderService;

@Component
public class OrderCreatedListener {
    
    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    private final OrderService orderService;

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message){
        logger.info("Message consumed:{}", message);

        orderService.saveOrder(message.getPayload());
        logger.info("Order saved: {}", message.getPayload().codigoPedido());
    }
}
