package com.example.lowleveldesign.pubsubsystem.repository.impl;

import com.example.lowleveldesign.pubsubsystem.domain.Subscriber;
import com.example.lowleveldesign.pubsubsystem.repository.SubscriberRepository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SubscriberRepositoryImpl implements SubscriberRepository {
    private Map<String, Subscriber> subscribers = new ConcurrentHashMap<>();

    @Override
    public Subscriber save(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
        return subscriber;
    }

    @Override
    public Optional<Subscriber> findById(String subscriberId) {
        return Optional.ofNullable(subscribers.get(subscriberId));
    }

    @Override
    public List<Subscriber> findAll() {
        return new ArrayList<>(subscribers.values());
    }

    @Override
    public void updateOnlineStatus(String subscriberId, boolean isOnline, String connectionId) {
        Subscriber subscriber = subscribers.get(subscriberId);
        if (subscriber != null) {
            subscriber.setOnline(isOnline);
            subscriber.setRealtimeConnectionId(connectionId);
            subscriber.setLastHeartbeat(System.currentTimeMillis());
        }
    }

    @Override
    public void deleteById(String subscriberId) {
        subscribers.remove(subscriberId);
    }
}
