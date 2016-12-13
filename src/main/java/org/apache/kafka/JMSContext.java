package org.apache.kafka;

import javax.jms.*;
import javax.jms.Connection;
import javax.jms.JMSProducer;
import java.io.Serializable;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class JMSContext<T extends javax.jms.JMSContext> extends ForwardingObject<T> implements javax.jms.JMSContext {

    public JMSContext(T jmsContext){
        super(jmsContext);
    }

    public javax.jms.JMSContext createContext(int sessionMode) {
        return new JMSContext(delegate().createContext(sessionMode));
    }

    public JMSProducer createProducer() {
        return delegate().createProducer();
    }

    public String getClientID() {
        return delegate().getClientID();
    }

    public void setClientID(String clientID) {
        delegate().setClientID(clientID);
    }

    public ConnectionMetaData getMetaData() {
        return delegate().getMetaData();
    }

    public ExceptionListener getExceptionListener() {
        return delegate().getExceptionListener();
    }

    public void setExceptionListener(ExceptionListener listener) {
        delegate().setExceptionListener(listener);
    }

    public void start() {
        delegate().start();
    }

    public void stop() {
        delegate().stop();
    }

    public void setAutoStart(boolean autoStart) {
        delegate().setAutoStart(autoStart);
    }

    public boolean getAutoStart() {
        return delegate().getAutoStart();
    }

    public void close() {
        delegate().close();
    }

    public BytesMessage createBytesMessage() {
        return delegate().createBytesMessage();
    }

    public MapMessage createMapMessage() {
        return delegate().createMapMessage();
    }

    public Message createMessage() {
        return delegate().createMessage();
    }

    public ObjectMessage createObjectMessage() {
        return delegate().createObjectMessage();
    }

    public ObjectMessage createObjectMessage(Serializable object) {
        return delegate().createObjectMessage(object);
    }

    public StreamMessage createStreamMessage() {
        return delegate().createStreamMessage();
    }

    public TextMessage createTextMessage() {
        return delegate().createTextMessage();
    }

    public TextMessage createTextMessage(String text) {
        return delegate().createTextMessage(text);
    }

    public boolean getTransacted() {
        return delegate().getTransacted();
    }

    public int getSessionMode() {
        return delegate().getSessionMode();
    }

    public void commit() {
        delegate().commit();
    }

    public void rollback() {
        delegate().rollback();
    }

    public void recover() {
        delegate().recover();
    }

    public JMSConsumer createConsumer(Destination destination) {
        return delegate().createConsumer(destination);
    }

    public JMSConsumer createConsumer(Destination destination, String messageSelector) {
        return delegate().createConsumer(destination, messageSelector);
    }

    public JMSConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) {
        return delegate().createConsumer(destination, messageSelector, noLocal);
    }

    public Queue createQueue(String queueName) {
        return delegate().createQueue(queueName);
    }

    public Topic createTopic(String topicName) {
        return delegate().createTopic(topicName);
    }

    public JMSConsumer createDurableConsumer(Topic topic, String name) {
        return delegate().createDurableConsumer(topic, name);
    }

    public JMSConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal) {
        return delegate().createDurableConsumer(topic, name, messageSelector, noLocal);
    }

    public JMSConsumer createSharedDurableConsumer(Topic topic, String name) {
        return delegate().createSharedDurableConsumer(topic, name);
    }

    public JMSConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector) {
        return delegate().createSharedDurableConsumer(topic, name, messageSelector);
    }

    public JMSConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) {
        return delegate().createSharedConsumer(topic, sharedSubscriptionName);
    }

    public JMSConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector) {
        return delegate().createSharedConsumer(topic, sharedSubscriptionName, messageSelector);
    }

    public QueueBrowser createBrowser(Queue queue) {
        return delegate().createBrowser(queue);
    }

    public QueueBrowser createBrowser(Queue queue, String messageSelector) {
        return delegate().createBrowser(queue, messageSelector);
    }

    public TemporaryQueue createTemporaryQueue() {
        return delegate().createTemporaryQueue();
    }

    public TemporaryTopic createTemporaryTopic() {
        return delegate().createTemporaryTopic();
    }

    public void unsubscribe(String name) {
        delegate().unsubscribe(name);
    }

    public void acknowledge() {
        delegate().acknowledge();
    }
}
