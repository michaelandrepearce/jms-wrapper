package org.apache.kafka;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class QueueSender<T extends javax.jms.QueueSender> extends MessageProducer<T> implements javax.jms.QueueSender {

    public QueueSender(T queueSender){
        super(queueSender);
    }

    public Queue getQueue() throws JMSException {
        return delegate().getQueue();
    }

    public void send(Queue queue, Message message) throws JMSException {
        delegate().send(queue, message);
    }

    public void send(Queue queue, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        delegate().send(queue, message, deliveryMode, priority, timeToLive);
    }
}
