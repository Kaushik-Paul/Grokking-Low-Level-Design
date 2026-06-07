package com.example.lowleveldesign.pubsubsystem.domain;

import com.example.lowleveldesign.pubsubsystem.domain.observer.MessageSubject;

public class Topic {
    private String id;
    private String name;
    private boolean isActive;
    private long createdAt;
    // Added the subject that belongs to it so that observer pattern can work 
    private MessageSubject messageSubject;

    public Topic() {
        this.messageSubject = new MessageSubject();
    }

    public Topic(String id, String name, boolean isActive, long createdAt) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.messageSubject = new MessageSubject();
    }

    // Getter for MessageSubject to use directly
    public MessageSubject getMessageSubject() {
        return messageSubject;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", emailSubscribers=" + messageSubject.getEmailSubscribers().size() +
                ", realtimeSubscribers=" + messageSubject.getRealtimeSubscribers().size() +
                '}';
    }
}
