package com.example.lowleveldesign.pubsubsystem.domain;

public class MessageDelivery {
    private String id;
    private String messageId;
    private String subscriberId;
    private DeliveryChannel channel;
    private DeliveryStatus status;
    private long createdAt;
    private Long acknowledgedAt;

    public MessageDelivery() {}

    public MessageDelivery(String id, String messageId, String subscriberId, DeliveryChannel channel, 
                          DeliveryStatus status, long createdAt, Long acknowledgedAt) {
        this.id = id;
        this.messageId = messageId;
        this.subscriberId = subscriberId;
        this.channel = channel;
        this.status = status;
        this.createdAt = createdAt;
        this.acknowledgedAt = acknowledgedAt;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public DeliveryChannel getChannel() {
        return channel;
    }

    public void setChannel(DeliveryChannel channel) {
        this.channel = channel;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getAcknowledgedAt() {
        return acknowledgedAt;
    }

    public void setAcknowledgedAt(Long acknowledgedAt) {
        this.acknowledgedAt = acknowledgedAt;
    }

    @Override
    public String toString() {
        return "MessageDelivery{" +
                "id='" + id + '\'' +
                ", messageId='" + messageId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", channel=" + channel +
                ", status=" + status +
                '}';
    }
}
