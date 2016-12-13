package org.apache.kafka;

import javax.jms.*;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class MessageProducer<T extends javax.jms.MessageProducer> extends ForwardingObject<T> implements javax.jms.MessageProducer {

    public MessageProducer(T messageProducer){
        super(messageProducer);
    }

    public void setDisableMessageID(boolean value) throws JMSException {
        delegate().setDisableMessageID(value);
    }

    public boolean getDisableMessageID() throws JMSException {
        return delegate().getDisableMessageID();
    }

    public void setDisableMessageTimestamp(boolean value) throws JMSException {
        delegate().setDisableMessageTimestamp(value);
    }

    public boolean getDisableMessageTimestamp() throws JMSException {
        return delegate().getDisableMessageTimestamp();
    }

    public void setDeliveryMode(int deliveryMode) throws JMSException {
        delegate().setDeliveryMode(deliveryMode);
    }

    public int getDeliveryMode() throws JMSException {
        return delegate().getDeliveryMode();
    }

    public void setPriority(int defaultPriority) throws JMSException {
        delegate().setPriority(defaultPriority);
    }

    public int getPriority() throws JMSException {
        return delegate().getPriority();
    }

    public void setTimeToLive(long timeToLive) throws JMSException {
        delegate().setTimeToLive(timeToLive);
    }

    public long getTimeToLive() throws JMSException {
        return delegate().getTimeToLive();
    }

    public void setDeliveryDelay(long deliveryDelay) throws JMSException {
        delegate().setDeliveryDelay(deliveryDelay);
    }

    public long getDeliveryDelay() throws JMSException {
        return delegate().getDeliveryDelay();
    }

    public Destination getDestination() throws JMSException {
        return delegate().getDestination();
    }

    public void close() throws JMSException {
        delegate().close();
    }

    public void send(Message message) throws JMSException {
        delegate().send(message);
    }

    public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        delegate().send(message, deliveryMode, priority, timeToLive);
    }

    public void send(Destination destination, Message message) throws JMSException {
        delegate().send(destination, message);
    }

    public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        delegate().send(destination, message, deliveryMode, priority, timeToLive);
    }

    public void send(Message message, CompletionListener completionListener) throws JMSException {
        delegate().send(message, completionListener);
    }

    public void send(Message message, int deliveryMode, int priority, long timeToLive, CompletionListener completionListener) throws JMSException {
        delegate().send(message, deliveryMode, priority, timeToLive, completionListener);
    }

    public void send(Destination destination, Message message, CompletionListener completionListener) throws JMSException {
        delegate().send(destination, message, completionListener);
    }

    public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive, CompletionListener completionListener) throws JMSException {
        delegate().send(destination, message, deliveryMode, priority, timeToLive, completionListener);
    }
}
