package com.example.lowleveldesign.pubsubsystem.controller;

import com.example.lowleveldesign.pubsubsystem.service.MessageService;

public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void acknowledgeMessage(String messageId, String subscriberId) {
        messageService.acknowledgeMessage(messageId, subscriberId);
    }
}
