package com.example.lowleveldesign.pubsubsystem.controller;

import com.example.lowleveldesign.pubsubsystem.domain.Message;
import com.example.lowleveldesign.pubsubsystem.service.PublisherService;

public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public Message publishMessage(String topicId, String content) {
        return publisherService.publishMessage(topicId, content);
    }
}
