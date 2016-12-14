package is.sourcery.jms.monitoring;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class Session<T extends javax.jms.Session> extends ForwardingObject<T> implements javax.jms.Session {

    private is.sourcery.jms.monitoring.Connection connection;

    public Session(Connection connection, T session){
        super(session);
        this.connection = connection;
    }
    
    public Connection getConnection(){
        return connection;
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

    public javax.jms.MessageListener getMessageListener() throws JMSException {
        return delegate().getMessageListener();
    }

    public void setMessageListener(javax.jms.MessageListener listener) throws JMSException {
        delegate().setMessageListener(listener);
    }

    public void run() {
        delegate().run();
    }

    public javax.jms.MessageProducer createProducer(Destination destination) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageProducer(this, delegate().createProducer(destination));
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createConsumer(destination));
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createConsumer(destination, messageSelector));
    }

    public javax.jms.MessageConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createConsumer(destination, messageSelector, noLocal));
    }

    public javax.jms.MessageConsumer createSharedConsumer(Topic topic, String subscriptionName) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createSharedConsumer(topic, subscriptionName));
    }

    public javax.jms.MessageConsumer createSharedConsumer(Topic topic, String subscriptionName, String messageSelector) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createSharedConsumer(topic, subscriptionName, messageSelector));
    }

    public Queue createQueue(String queueName) throws JMSException {
        return delegate().createQueue(queueName);
    }

    public Topic createTopic(String topicName) throws JMSException {
        return delegate().createTopic(topicName);
    }

    public javax.jms.TopicSubscriber createDurableSubscriber(Topic topic, String subscriptionName) throws JMSException {
        return new TopicSubscriber(this, delegate().createDurableSubscriber(topic, subscriptionName));
    }

    public javax.jms.TopicSubscriber createDurableSubscriber(Topic topic, String subscriptionName, String messageSelector, boolean noLocal) throws JMSException {
        return new TopicSubscriber(this, delegate().createDurableSubscriber(topic, subscriptionName, messageSelector, noLocal));
    }

    public javax.jms.MessageConsumer createDurableConsumer(Topic topic, String subscriptionName) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createDurableConsumer(topic, subscriptionName));
    }

    public javax.jms.MessageConsumer createDurableConsumer(Topic topic, String subscriptionName, String messageSelector, boolean noLocal) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createDurableConsumer(topic, subscriptionName, messageSelector, noLocal));
    }

    public javax.jms.MessageConsumer createSharedDurableConsumer(Topic topic, String subscriptionName) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createSharedDurableConsumer(topic, subscriptionName));
    }

    public javax.jms.MessageConsumer createSharedDurableConsumer(Topic topic, String subscriptionName, String messageSelector) throws JMSException {
        return new is.sourcery.jms.monitoring.MessageConsumer(this, delegate().createSharedDurableConsumer(topic, subscriptionName, messageSelector));
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
