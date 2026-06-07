package com.example.lowleveldesign.pubsubsystem.domain.observer;

import com.example.lowleveldesign.pubsubsystem.domain.Message;

public class EmailSubscriber implements SubscriberObserver {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(Message message) {
        // Connection sending email to the email
        System.out.println("Sending EMAIL to " + email + ": New message in topic -> " + message.getContent());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
