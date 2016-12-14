package is.sourcery.jms.monitoring;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class JMSContext<T extends javax.jms.JMSContext> extends ForwardingObject<T> implements javax.jms.JMSContext {

    private is.sourcery.jms.monitoring.ConnectionFactory connectionFactory;

    public JMSContext(is.sourcery.jms.monitoring.ConnectionFactory connectionFactory, T jmsContext){
        super(jmsContext);
        this.connectionFactory = connectionFactory;
    }
    
    public is.sourcery.jms.monitoring.ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public javax.jms.JMSContext createContext(int sessionMode) {
        return new JMSContext(connectionFactory, delegate().createContext(sessionMode));
    }

    public javax.jms.JMSProducer createProducer() {
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

    public javax.jms.JMSConsumer createConsumer(Destination destination) {
        return delegate().createConsumer(destination);
    }

    public javax.jms.JMSConsumer createConsumer(Destination destination, String messageSelector) {
        return delegate().createConsumer(destination, messageSelector);
    }

    public javax.jms.JMSConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) {
        return delegate().createConsumer(destination, messageSelector, noLocal);
    }

    public Queue createQueue(String queueName) {
        return delegate().createQueue(queueName);
    }

    public Topic createTopic(String topicName) {
        return delegate().createTopic(topicName);
    }

    public javax.jms.JMSConsumer createDurableConsumer(Topic topic, String subscriptionName) {
        return delegate().createDurableConsumer(topic, subscriptionName);
    }

    public javax.jms.JMSConsumer createDurableConsumer(Topic topic, String subscriptionName, String messageSelector, boolean noLocal) {
        return delegate().createDurableConsumer(topic, subscriptionName, messageSelector, noLocal);
    }

    public javax.jms.JMSConsumer createSharedDurableConsumer(Topic topic, String subscriptionName) {
        return delegate().createSharedDurableConsumer(topic, subscriptionName);
    }

    public javax.jms.JMSConsumer createSharedDurableConsumer(Topic topic, String subscriptionName, String messageSelector) {
        return delegate().createSharedDurableConsumer(topic, subscriptionName, messageSelector);
    }

    public javax.jms.JMSConsumer createSharedConsumer(Topic topic, String subscriptionName) {
        return delegate().createSharedConsumer(topic, subscriptionName);
    }

    public javax.jms.JMSConsumer createSharedConsumer(Topic topic, String subscriptionName, String messageSelector) {
        return delegate().createSharedConsumer(topic, subscriptionName, messageSelector);
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
