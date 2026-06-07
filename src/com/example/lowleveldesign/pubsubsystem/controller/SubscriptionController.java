package com.example.lowleveldesign.pubsubsystem.controller;

import com.example.lowleveldesign.pubsubsystem.domain.Subscription;
import com.example.lowleveldesign.pubsubsystem.service.SubscriptionService;

public class SubscriptionController {
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    public Subscription subscribeToTopic(String topicId, String subscriberId) {
        return subscriptionService.subscribeToTopic(topicId, subscriberId);
    }

    public void unsubscribeFromTopic(String topicId, String subscriberId) {
        subscriptionService.unsubscribeFromTopic(topicId, subscriberId);
    }
}
