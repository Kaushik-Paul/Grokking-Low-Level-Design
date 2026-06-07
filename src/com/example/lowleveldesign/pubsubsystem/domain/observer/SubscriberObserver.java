package com.example.lowleveldesign.pubsubsystem.domain.observer;

import com.example.lowleveldesign.pubsubsystem.domain.Message;

public interface SubscriberObserver {
    void update(Message message);
}
