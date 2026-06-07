package com.example.lowleveldesign.pubsubsystem.repository.impl;

import com.example.lowleveldesign.pubsubsystem.domain.Message;
import com.example.lowleveldesign.pubsubsystem.repository.MessageRepository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageRepositoryImpl implements MessageRepository {
    private Map<String, Message> messages = new ConcurrentHashMap<>();

    @Override
    public Message save(Message message) {
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Optional<Message> findById(String messageId) {
        return Optional.ofNullable(messages.get(messageId));
    }

    @Override
    public void deleteById(String messageId) {
        messages.remove(messageId);
    }
}
