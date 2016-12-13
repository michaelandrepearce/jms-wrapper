package org.apache.kafka;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class MessageConsumer<T extends javax.jms.MessageConsumer> extends ForwardingObject<T> implements javax.jms.MessageConsumer {

    public MessageConsumer(T messageConsumer){
        super(messageConsumer);
    }

    public String getMessageSelector() throws JMSException {
        return delegate().getMessageSelector();
    }

    public MessageListener getMessageListener() throws JMSException {
        return delegate().getMessageListener();
    }

    public void setMessageListener(MessageListener listener) throws JMSException {
        delegate().setMessageListener(listener);
    }

    public Message receive() throws JMSException {
        return delegate().receive();
    }

    public Message receive(long timeout) throws JMSException {
        return delegate().receive(timeout);
    }

    public Message receiveNoWait() throws JMSException {
        return delegate().receiveNoWait();
    }

    public void close() throws JMSException {
        delegate().close();
    }
}
