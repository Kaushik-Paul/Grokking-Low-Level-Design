package com.example.lowleveldesign.pubsubsystem.repository;

import com.example.lowleveldesign.pubsubsystem.domain.Subscriber;
import java.util.List;
import java.util.Optional;

public interface SubscriberRepository {
    Subscriber save(Subscriber subscriber);
    Optional<Subscriber> findById(String subscriberId);
    List<Subscriber> findAll();
    void updateOnlineStatus(String subscriberId, boolean isOnline, String connectionId);
    void deleteById(String subscriberId);
}
