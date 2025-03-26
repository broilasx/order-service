package com.buildrun.orderms.listener.dto;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido,
                                Long codigoClient,
                                List<OrderItemEvent> item) {
    
}
