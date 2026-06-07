package com.example.lowleveldesign.pubsubsystem.domain;

public class Subscriber {
    private String id;
    private String email;
    private String realtimeConnectionId;
    private boolean isOnline;
    private long createdAt;
    private long lastHeartbeat;

    public Subscriber() {}

    public Subscriber(String id, String email, String realtimeConnectionId, boolean isOnline, long createdAt, long lastHeartbeat) {
        this.id = id;
        this.email = email;
        this.realtimeConnectionId = realtimeConnectionId;
        this.isOnline = isOnline;
        this.createdAt = createdAt;
        this.lastHeartbeat = lastHeartbeat;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealtimeConnectionId() {
        return realtimeConnectionId;
    }

    public void setRealtimeConnectionId(String realtimeConnectionId) {
        this.realtimeConnectionId = realtimeConnectionId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastHeartbeat() {
        return lastHeartbeat;
    }

    public void setLastHeartbeat(long lastHeartbeat) {
        this.lastHeartbeat = lastHeartbeat;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }
}
