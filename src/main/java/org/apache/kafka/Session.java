package org.apache.kafka;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class Session<T extends javax.jms.Session> extends ForwardingObject<T> implements javax.jms.Session {

    public Session(T session){
        super(session);
    }

    public BytesMessage createBytesMessage() throws JMSException {
        return delegate().createBytesMessage();
    }

    public MapMessage createMapMessage() throws JMSException {
        return delegate().createMapMessage();
    }

    public Message createMessage() throws JMSException {
        return delegate().createMessage();
    }

    public ObjectMessage createObjectMessage() throws JMSException {
        return delegate().createObjectMessage();
    }

    public ObjectMessage createObjectMessage(Serializable object) throws JMSException {
        return delegate().createObjectMessage(object);
    }

    public StreamMessage createStreamMessage() throws JMSException {
        return delegate().createStreamMessage();
    }

    public TextMessage createTextMessage() throws JMSException {
        return delegate().createTextMessage();
    }

    public TextMessage createTextMessage(String text) throws JMSException {
        return delegate().createTextMessage(text);
    }

    public boolean getTransacted() throws JMSException {
        return delegate().getTransacted();
    }

    public int getAcknowledgeMode() throws JMSException {
        return delegate().getAcknowledgeMode();
    }

    public void commit() throws JMSException {
        delegate().commit();
    }

    public void rollback() throws JMSException {
        delegate().rollback();
    }

    public void close() throws JMSException {
        delegate().close();
    }

    public void recover() throws JMSException {
        delegate().recover();
    }

    public MessageListener getMessageListener() throws JMSException {
        return delegate().getMessageListener();
    }

    public void setMessageListener(MessageListener listener) throws JMSException {
        delegate().setMessageListener(listener);
    }

    public void run() {
        delegate().run();
    }

    public javax.jms.MessageProducer createProducer(Destination destination) throws JMSException {
        return delegate().createProducer(destination);
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination) throws JMSException {
        return delegate().createConsumer(destination);
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
        return delegate().createConsumer(destination, messageSelector);
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) throws JMSException {
        return delegate().createConsumer(destination, messageSelector, noLocal);
    }

    public javax.jms.MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) throws JMSException {
        return delegate().createSharedConsumer(topic, sharedSubscriptionName);
    }

    public javax.jms.MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector) throws JMSException {
        return delegate().createSharedConsumer(topic, sharedSubscriptionName, messageSelector);
    }

    public Queue createQueue(String queueName) throws JMSException {
        return delegate().createQueue(queueName);
    }

    public Topic createTopic(String topicName) throws JMSException {
        return delegate().createTopic(topicName);
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
        return delegate().createDurableSubscriber(topic, name);
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
        return delegate().createDurableSubscriber(topic, name, messageSelector, noLocal);
    }

    public javax.jms.MessageConsumer createDurableConsumer(Topic topic, String name) throws JMSException {
        return delegate().createDurableConsumer(topic, name);
    }

    public javax.jms.MessageConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
        return delegate().createDurableConsumer(topic, name, messageSelector, noLocal);
    }

    public javax.jms.MessageConsumer createSharedDurableConsumer(Topic topic, String name) throws JMSException {
        return delegate().createSharedDurableConsumer(topic, name);
    }

    public javax.jms.MessageConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector) throws JMSException {
        return delegate().createSharedDurableConsumer(topic, name, messageSelector);
    }

    public QueueBrowser createBrowser(Queue queue) throws JMSException {
        return delegate().createBrowser(queue);
    }

    public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
        return delegate().createBrowser(queue, messageSelector);
    }

    public TemporaryQueue createTemporaryQueue() throws JMSException {
        return delegate().createTemporaryQueue();
    }

    public TemporaryTopic createTemporaryTopic() throws JMSException {
        return delegate().createTemporaryTopic();
    }

    public void unsubscribe(String name) throws JMSException {
        delegate().unsubscribe(name);
    }
}
