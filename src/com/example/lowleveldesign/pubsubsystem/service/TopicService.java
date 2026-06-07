package com.example.lowleveldesign.pubsubsystem.service;

import com.example.lowleveldesign.pubsubsystem.domain.Topic;
import com.example.lowleveldesign.pubsubsystem.repository.TopicRepository;
import java.util.List;
import java.util.UUID;

public class TopicService {
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(String name) {
        Topic topic = new Topic(UUID.randomUUID().toString(), name, true, System.currentTimeMillis());
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public void deactivateTopic(String topicId) {
        topicRepository.findById(topicId).ifPresent(topic -> {
            topic.setActive(false);
            topicRepository.save(topic);
        });
    }
}
