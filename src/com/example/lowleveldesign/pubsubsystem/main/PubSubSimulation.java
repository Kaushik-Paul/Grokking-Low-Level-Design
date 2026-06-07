package com.example.lowleveldesign.pubsubsystem.main;

import com.example.lowleveldesign.pubsubsystem.controller.TopicController;
import com.example.lowleveldesign.pubsubsystem.controller.SubscriberController;
import com.example.lowleveldesign.pubsubsystem.controller.SubscriptionController;
import com.example.lowleveldesign.pubsubsystem.controller.PublisherController;
import com.example.lowleveldesign.pubsubsystem.controller.MessageController;
import com.example.lowleveldesign.pubsubsystem.repository.TopicRepository;
import com.example.lowleveldesign.pubsubsystem.repository.SubscriberRepository;
import com.example.lowleveldesign.pubsubsystem.repository.MessageRepository;
import com.example.lowleveldesign.pubsubsystem.repository.SubscriptionRepository;
import com.example.lowleveldesign.pubsubsystem.repository.MessageDeliveryRepository;
import com.example.lowleveldesign.pubsubsystem.repository.impl.TopicRepositoryImpl;
import com.example.lowleveldesign.pubsubsystem.repository.impl.SubscriberRepositoryImpl;
import com.example.lowleveldesign.pubsubsystem.repository.impl.MessageRepositoryImpl;
import com.example.lowleveldesign.pubsubsystem.repository.impl.SubscriptionRepositoryImpl;
import com.example.lowleveldesign.pubsubsystem.repository.impl.MessageDeliveryRepositoryImpl;
import com.example.lowleveldesign.pubsubsystem.service.TopicService;
import com.example.lowleveldesign.pubsubsystem.service.SubscriberService;
import com.example.lowleveldesign.pubsubsystem.service.SubscriptionService;
import com.example.lowleveldesign.pubsubsystem.service.PublisherService;
import com.example.lowleveldesign.pubsubsystem.service.MessageService;
import com.example.lowleveldesign.pubsubsystem.domain.Topic;
import com.example.lowleveldesign.pubsubsystem.domain.Subscriber;
import com.example.lowleveldesign.pubsubsystem.domain.Subscription;
import com.example.lowleveldesign.pubsubsystem.domain.Message;

public class PubSubSimulation {
    public static void main(String[] args) {
        System.out.println("=== PUB/SUB SYSTEM SIMULATION ===\n");

        // Initialize repositories
        TopicRepository topicRepository = new TopicRepositoryImpl();
        SubscriberRepository subscriberRepository = new SubscriberRepositoryImpl();
        MessageRepository messageRepository = new MessageRepositoryImpl();
        SubscriptionRepository subscriptionRepository = new SubscriptionRepositoryImpl();
        MessageDeliveryRepository messageDeliveryRepository = new MessageDeliveryRepositoryImpl();

        // Initialize services
        TopicService topicService = new TopicService(topicRepository);
        SubscriberService subscriberService = new SubscriberService(subscriberRepository, subscriptionRepository, messageDeliveryRepository, topicRepository);
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository, subscriberRepository, topicRepository);
        PublisherService publisherService = new PublisherService(topicRepository, messageRepository, messageDeliveryRepository);
        MessageService messageService = new MessageService(messageDeliveryRepository);

        // Initialize controllers
        TopicController topicController = new TopicController(topicService);
        SubscriberController subscriberController = new SubscriberController(subscriberService);
        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
        PublisherController publisherController = new PublisherController(publisherService);
        MessageController messageController = new MessageController(messageService);

        // Simulation
        System.out.println("1. Creating topics...");
        Topic techTopic = topicController.createTopic("Technology");
        Topic newsTopic = topicController.createTopic("News");
        System.out.println("Created topics: " + topicController.getAllTopics());

        System.out.println("\n2. Registering subscribers...");
        Subscriber alice = subscriberController.registerSubscriber("alice@example.com");
        Subscriber bob = subscriberController.registerSubscriber("bob@example.com");
        System.out.println("Registered subscribers: " + alice + ", " + bob);

        System.out.println("\n3. Subscribing to topics...");
        Subscription sub1 = subscriptionController.subscribeToTopic(techTopic.getId(), alice.getId());
        Subscription sub2 = subscriptionController.subscribeToTopic(techTopic.getId(), bob.getId());
        Subscription sub3 = subscriptionController.subscribeToTopic(newsTopic.getId(), alice.getId());
        System.out.println("Subscriptions created");

        System.out.println("\n4. Publishing messages...");
        Message msg1 = publisherController.publishMessage(techTopic.getId(), "New AI breakthrough announced!");
        Message msg2 = publisherController.publishMessage(newsTopic.getId(), "Breaking: Major political update");
        System.out.println("Messages published: " + msg1 + ", " + msg2);

        System.out.println("\n5. Testing online/offline status...");
        subscriberController.goOnline(alice.getId(), "conn-123");
        subscriberController.goOffline(bob.getId());
        System.out.println("Status changes applied");

        System.out.println("\n6. Publishing another message...");
        Message msg3 = publisherController.publishMessage(techTopic.getId(), "Tech conference next week!");
        System.out.println("Message published: " + msg3);

        System.out.println("\n7. Acknowledging message...");
        messageController.acknowledgeMessage(msg1.getId(), alice.getId());
        System.out.println("Message acknowledged");

        System.out.println("\n=== SIMULATION COMPLETED ===");
    }
}
