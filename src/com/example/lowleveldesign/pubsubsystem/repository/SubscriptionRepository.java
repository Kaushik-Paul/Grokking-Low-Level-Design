package com.example.lowleveldesign.pubsubsystem.repository;

import com.example.lowleveldesign.pubsubsystem.domain.Subscription;
import java.util.List;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);
    List<Subscription> findByTopic(String topicId);
    List<Subscription> findBySubscriber(String subscriberId);
    void deactivateSubscription(String topicId, String subscriberId);
    void deleteById(String subscriptionId);
}
