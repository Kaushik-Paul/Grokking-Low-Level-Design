package com.example.lowleveldesign.pubsubsystem.domain.observer;

import com.example.lowleveldesign.pubsubsystem.domain.Message;

public class RealtimeSubscriber implements SubscriberObserver {
    private String connectionId;
    private String subscriberId;

    public RealtimeSubscriber(String connectionId, String subscriberId) {
        this.connectionId = connectionId;
        this.subscriberId = subscriberId;
    }

    @Override
    public void update(Message message) {
        System.out.println("Sending REALTIME to " + subscriberId + " (connection: " + connectionId + "): New message -> " + message.getContent());
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }
}
