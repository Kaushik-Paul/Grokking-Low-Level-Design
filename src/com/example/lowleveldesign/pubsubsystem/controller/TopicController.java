package com.example.lowleveldesign.pubsubsystem.controller;

import com.example.lowleveldesign.pubsubsystem.domain.Topic;
import com.example.lowleveldesign.pubsubsystem.service.TopicService;
import java.util.List;

public class TopicController {
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    public Topic createTopic(String name) {
        // Validate 
        return topicService.createTopic(name);
    }

    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    public void deactivateTopic(String topicId) {
        topicService.deactivateTopic(topicId);
    }
}
