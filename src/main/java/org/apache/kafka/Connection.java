package org.apache.kafka;

import javax.jms.*;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class Connection<T extends javax.jms.Connection> extends ForwardingObject<T> implements javax.jms.Connection {

    public Connection(T connection){
        super(connection);
    }

    public javax.jms.Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
        return delegate().createSession(transacted, acknowledgeMode);
    }

    public javax.jms.Session createSession(int sessionMode) throws JMSException {
        return delegate().createSession(sessionMode);
    }

    public javax.jms.Session createSession() throws JMSException {
        return delegate().createSession();
    }

    public String getClientID() throws JMSException {
        return delegate().getClientID();
    }

    public void setClientID(String clientID) throws JMSException {
        delegate().setClientID(clientID);
    }

    public ConnectionMetaData getMetaData() throws JMSException {
        return delegate().getMetaData();
    }

    public ExceptionListener getExceptionListener() throws JMSException {
        return delegate().getExceptionListener();
    }

    public void setExceptionListener(ExceptionListener listener) throws JMSException {
        delegate().setExceptionListener(listener);
    }

    public void start() throws JMSException {
        delegate().start();
    }

    public void stop() throws JMSException {
        delegate().stop();
    }

    public void close() throws JMSException {
        delegate().start();
    }

    public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return delegate().createConnectionConsumer(destination, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return delegate().createSharedConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return delegate().createDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return delegate().createSharedDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }
}
