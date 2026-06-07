# Pub/Sub System LLD - Java

A comprehensive publish-subscribe messaging system demonstrating the Observer design pattern, layered architecture, and real-time message delivery.

## Overview

This publish-subscribe system enables asynchronous communication between publishers and subscribers through topics. It demonstrates the application of several design patterns including Observer, Repository, and Layered Architecture (Controller-Service-Repository). The system supports multiple delivery channels (email and realtime), message delivery tracking, and subscriber online/offline status management.

## Features

- **Topic Management**: Create and manage topics for message categorization
- **Subscriber Management**: Register subscribers with email and online/offline status tracking
- **Subscription System**: Subscribe/unsubscribe subscribers to topics
- **Message Publishing**: Publish messages to topics with automatic subscriber notification
- **Observer Pattern**: Real-time notifications through multiple channels (Email, Realtime)
- **Message Delivery Tracking**: Track delivery status and acknowledgments
- **Online/Offline Status**: Manage subscriber connection status for realtime delivery
- **Layered Architecture**: Clean separation with Controller, Service, and Repository layers
- **Extensible Design**: Easy to add new delivery channels or notification types

## Architecture

### Core Components

- **Topic**: Represents a message topic with subscriber lists and observer pattern integration
- **Subscriber**: Represents a user with email, connection ID, and online status
- **Subscription**: Represents a subscriber's subscription to a topic
- **Message**: Represents a published message with content and timestamp
- **MessageDelivery**: Tracks delivery status for each message to each subscriber
- **DeliveryChannel**: Enum for delivery channels (EMAIL, REALTIME)
- **DeliveryStatus**: Enum for delivery status (PENDING, DELIVERED, ACKNOWLEDGED, FAILED)

### Observer Pattern Implementation

- **MessageSubject**: Maintains lists of email and realtime subscribers, notifies them of new messages
- **SubscriberObserver**: Interface for subscriber notification (update method)
- **EmailSubscriber**: Implements email-based notification
- **RealtimeSubscriber**: Implements real-time socket-based notification

### Package Structure

```
com.example.lowleveldesign.pubsubsystem/
├── controller/           # API layer for user interactions
│   ├── TopicController
│   ├── SubscriberController
│   ├── SubscriptionController
│   ├── PublisherController
│   └── MessageController
├── service/              # Business logic layer
│   ├── TopicService
│   ├── SubscriberService
│   ├── SubscriptionService
│   ├── PublisherService
│   └── MessageService
├── repository/           # Data access interfaces
│   ├── TopicRepository
│   ├── SubscriberRepository
│   ├── MessageRepository
│   ├── SubscriptionRepository
│   └── MessageDeliveryRepository
├── repository/impl/      # Data access implementations
│   ├── TopicRepositoryImpl
│   ├── SubscriberRepositoryImpl
│   ├── MessageRepositoryImpl
│   ├── SubscriptionRepositoryImpl
│   └── MessageDeliveryRepositoryImpl
├── domain/              # Domain models and entities
│   ├── Topic
│   ├── Subscriber
│   ├── Subscription
│   ├── Message
│   ├── MessageDelivery
│   ├── DeliveryChannel
│   ├── DeliveryStatus
│   ├── Priority
│   └── observer/        # Observer pattern implementations
│       ├── MessageSubject
│       ├── SubscriberObserver
│       ├── EmailSubscriber
│       └── RealtimeSubscriber
└── main/
    └── PubSubSimulation.java  # Demo and entry point
```

## Design Patterns Applied

- **Observer Pattern**: MessageSubject with SubscriberObserver implementations (EmailSubscriber, RealtimeSubscriber) for message notifications
- **Repository Pattern**: Data access abstraction for topics, subscribers, messages, subscriptions, and deliveries
- **Layered Architecture**: Controller → Service → Repository separation of concerns
- **Factory Pattern**: UUID-based ID generation for entities
- **Strategy Pattern**: Different delivery strategies (email vs realtime) through observer implementations

## Design Principles

- **Single Responsibility**: Each class has one clear purpose (controller handles API, service handles logic, repository handles data)
- **Open/Closed**: Open for extension (new delivery channels, notification types), closed for modification
- **Liskov Substitution**: All observer implementations are interchangeable
- **Interface Segregation**: Small, focused interfaces for each layer
- **Dependency Inversion**: High-level controllers depend on service interfaces, not implementations

## Usage Examples

### Basic Topic and Subscriber Setup

```java
// Initialize repositories and services
TopicRepository topicRepository = new TopicRepositoryImpl();
SubscriberRepository subscriberRepository = new SubscriberRepositoryImpl();
TopicService topicService = new TopicService(topicRepository);
SubscriberService subscriberService = new SubscriberService(subscriberRepository, ...);

// Create controllers
TopicController topicController = new TopicController(topicService);
SubscriberController subscriberController = new SubscriberController(subscriberService);

// Create topics
Topic techTopic = topicController.createTopic("Technology");
Topic newsTopic = topicController.createTopic("News");

// Register subscribers
Subscriber alice = subscriberController.registerSubscriber("alice@example.com");
Subscriber bob = subscriberController.registerSubscriber("bob@example.com");
```

### Subscription Management

```java
SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);

// Subscribe to topics
Subscription sub1 = subscriptionController.subscribeToTopic(techTopic.getId(), alice.getId());
Subscription sub2 = subscriptionController.subscribeToTopic(techTopic.getId(), bob.getId());
Subscription sub3 = subscriptionController.subscribeToTopic(newsTopic.getId(), alice.getId());
```

### Message Publishing

```java
PublisherController publisherController = new PublisherController(publisherService);

// Publish messages
Message msg1 = publisherController.publishMessage(techTopic.getId(), "New AI breakthrough announced!");
Message msg2 = publisherController.publishMessage(newsTopic.getId(), "Breaking: Major political update");
```

### Online/Offline Status Management

```java
// Set subscriber online
subscriberController.goOnline(alice.getId(), "conn-123");

// Set subscriber offline
subscriberController.goOffline(bob.getId());
```

### Message Acknowledgment

```java
MessageController messageController = new MessageController(messageService);

// Acknowledge message receipt
messageController.acknowledgeMessage(msg1.getId(), alice.getId());
```

## Compile and Run

From the project root:

```bash
# Compile all Java files
javac -d /tmp $(find src/com/example/lowleveldesign/pubsubsystem -name "*.java")

# Run the simulation
java -cp /tmp com.example.lowleveldesign.pubsubsystem.main.PubSubSimulation
```

## Demo Features

The `PubSubSimulation` class demonstrates:
1. Topic creation and management
2. Subscriber registration
3. Topic subscription
4. Message publishing with automatic notifications
5. Online/offline status management
6. Real-time email and socket notifications
7. Message acknowledgment
8. Background async message processing

## Notification Flow

1. **Publisher** publishes a message to a topic
2. **PublisherService** validates topic and saves message
3. **MessageSubject** notifies all registered subscribers:
   - **EmailSubscriber**: Sends email notification
   - **RealtimeSubscriber**: Sends real-time socket notification (if online)
4. **MessageDelivery** records are created for tracking
5. **Subscriber** can acknowledge message receipt
6. **MessageService** updates delivery status

## Extensibility

To add new functionality:

- **New Delivery Channel**: Implement `SubscriberObserver` interface (e.g., SMSSubscriber, PushNotificationSubscriber)
- **New Message Priority**: Add to `Priority` enum and update publishing logic
- **New Delivery Status**: Add to `DeliveryStatus` enum and update tracking logic
- **New Controller**: Add controller for additional features (e.g., TopicAdminController, SubscriberAnalyticsController)
- **Persistence**: Replace in-memory repositories with database implementations

## Requirements

- Java 21 or higher
- No external dependencies

## Future Enhancements

- Database persistence for all entities
- Message filtering and routing rules
- Dead letter queue for failed deliveries
- Message expiration and TTL
- Subscriber groups and permissions
- Message encryption and security
- WebSocket implementation for real-time delivery
- Retry mechanism for failed deliveries
- Analytics and monitoring dashboard
