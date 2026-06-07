package com.example.lowleveldesign.pubsubsystem.service;

import com.example.lowleveldesign.pubsubsystem.domain.Topic;
import com.example.lowleveldesign.pubsubsystem.domain.Message;
import com.example.lowleveldesign.pubsubsystem.repository.TopicRepository;
import com.example.lowleveldesign.pubsubsystem.repository.MessageRepository;
import com.example.lowleveldesign.pubsubsystem.repository.MessageDeliveryRepository;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PublisherService {
    private TopicRepository topicRepository;
    private MessageRepository messageRepository;
    private MessageDeliveryRepository messageDeliveryRepository;

    public PublisherService(TopicRepository topicRepository, 
                          MessageRepository messageRepository,
                          MessageDeliveryRepository messageDeliveryRepository) {
        this.topicRepository = topicRepository;
        this.messageRepository = messageRepository;
        this.messageDeliveryRepository = messageDeliveryRepository;
    }

    public Message publishMessage(String topicId, String content) {
        // Validate topic exists and is active
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));
        
        if (!topic.isActive()) {
            throw new RuntimeException("Topic is inactive: " + topicId);
        }

        // Create and save message
        Message message = new Message(UUID.randomUUID().toString(), topicId, content, System.currentTimeMillis());
        messageRepository.save(message);

        // Background notification processing
        CompletableFuture.runAsync(() -> {
            processMessageDeliveryAsync(message, topic);
        });

        return message;
    }

    private void processMessageDeliveryAsync(Message message, Topic topic) {
        // Notify subscribers (always)
        topic.getMessageSubject().notify(message);
        
        // TODO: Create delivery records for tracking for realtime ones... as email will be delivered 
        System.out.println("Background processing completed for message: " + message.getId());
    }
}
