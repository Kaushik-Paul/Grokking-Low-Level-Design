package com.example.lowleveldesign.pubsubsystem.domain;

public class Subscription {
    private String id;
    private String topicId;
    private String subscriberId;
    private boolean isActive;
    private long createdAt;

    public Subscription() {}

    public Subscription(String id, String topicId, String subscriberId, boolean isActive, long createdAt) {
        this.id = id;
        this.topicId = topicId;
        this.subscriberId = subscriberId;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
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
        return "Subscription{" +
                "id='" + id + '\'' +
                ", topicId='" + topicId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
