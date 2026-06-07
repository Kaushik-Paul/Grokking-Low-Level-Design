package com.example.lowleveldesign.pubsubsystem.service;

import com.example.lowleveldesign.pubsubsystem.domain.Subscription;
import com.example.lowleveldesign.pubsubsystem.domain.observer.EmailSubscriber;
import com.example.lowleveldesign.pubsubsystem.domain.observer.MessageSubject;
import com.example.lowleveldesign.pubsubsystem.domain.observer.RealtimeSubscriber;
import com.example.lowleveldesign.pubsubsystem.domain.observer.SubscriberObserver;
import com.example.lowleveldesign.pubsubsystem.repository.SubscriptionRepository;
import com.example.lowleveldesign.pubsubsystem.repository.SubscriberRepository;
import com.example.lowleveldesign.pubsubsystem.repository.TopicRepository;
import java.util.UUID;

public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;
    private SubscriberRepository subscriberRepository;
    private TopicRepository topicRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                             SubscriberRepository subscriberRepository,
                             TopicRepository topicRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriberRepository = subscriberRepository;
        this.topicRepository = topicRepository;
    }

    public Subscription subscribeToTopic(String topicId, String subscriberId) {
        Subscription subscription = new Subscription(UUID.randomUUID().toString(), topicId, 
                                                   subscriberId, true, System.currentTimeMillis());
        subscriptionRepository.save(subscription);
        
        // Add to topic subscriber lists
        topicRepository.findById(topicId).ifPresent(topic -> {
            subscriberRepository.findById(subscriberId).ifPresent(subscriber -> {
                // Always add to email list
                EmailSubscriber emailSub = new EmailSubscriber(subscriber.getEmail());
                topic.getMessageSubject().addEmailSubscriber(emailSub);
                
                // Add to realtime list if online
                if (subscriber.isOnline()) {
                    RealtimeSubscriber realtimeSub = new RealtimeSubscriber(
                        subscriber.getRealtimeConnectionId(), subscriberId);
                    topic.getMessageSubject().addRealtimeSubscriber(realtimeSub);
                }
            });
        });
        
        return subscription;
    }

    public void unsubscribeFromTopic(String topicId, String subscriberId) {
        subscriptionRepository.deactivateSubscription(topicId, subscriberId);
        
        // TODO: Remove from topic subscriber lists
        System.out.println("Unsubscribed " + subscriberId + " from topic " + topicId);
    }
}
