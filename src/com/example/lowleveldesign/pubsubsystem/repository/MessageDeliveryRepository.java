package com.example.lowleveldesign.pubsubsystem.repository;

import com.example.lowleveldesign.pubsubsystem.domain.DeliveryStatus;
import com.example.lowleveldesign.pubsubsystem.domain.MessageDelivery;
import java.util.List;

public interface MessageDeliveryRepository {
    MessageDelivery save(MessageDelivery delivery);
    List<MessageDelivery> findPendingBySubscriber(String subscriberId);
    void updateDeliveryStatus(String deliveryId, DeliveryStatus status);
    void deleteById(String deliveryId);
}
