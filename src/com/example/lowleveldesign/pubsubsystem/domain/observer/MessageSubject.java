package com.example.lowleveldesign.pubsubsystem.domain.observer;

import com.example.lowleveldesign.pubsubsystem.domain.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageSubject {
    private List<SubscriberObserver> emailSubscribers;
    private List<SubscriberObserver> realtimeSubscribers;

    public MessageSubject() {
        this.emailSubscribers = new CopyOnWriteArrayList<>();
        this.realtimeSubscribers = new CopyOnWriteArrayList<>();
    }

    public void addEmailSubscriber(SubscriberObserver subscriber) {
        emailSubscribers.add(subscriber);
    }

    public void removeEmailSubscriber(SubscriberObserver subscriber) {
        emailSubscribers.remove(subscriber);
    }

    public void addRealtimeSubscriber(SubscriberObserver subscriber) {
        realtimeSubscribers.add(subscriber);
    }

    public void removeRealtimeSubscriber(SubscriberObserver subscriber) {
        realtimeSubscribers.remove(subscriber);
    }

    public void notify(Message message) {
        notifyEmailSubscribers(message);
        notifyRealtimeSubscribers(message);
    }

    public void notifyEmailSubscribers(Message message) {
        for (SubscriberObserver subscriber : emailSubscribers) {
            subscriber.update(message);
        }
    }

    public void notifyRealtimeSubscribers(Message message) {
        for (SubscriberObserver subscriber : realtimeSubscribers) {
            subscriber.update(message);
        }
    }

    public List<SubscriberObserver> getEmailSubscribers() {
        return new ArrayList<>(emailSubscribers);
    }

    public List<SubscriberObserver> getRealtimeSubscribers() {
        return new ArrayList<>(realtimeSubscribers);
    }
}
